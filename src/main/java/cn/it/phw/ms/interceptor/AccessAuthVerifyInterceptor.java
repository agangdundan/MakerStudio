package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Action;
import cn.it.phw.ms.pojo.Usergroup;
import cn.it.phw.ms.service.ActionService;
import cn.it.phw.ms.service.UserGroupService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Component
public class AccessAuthVerifyInterceptor implements HandlerInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(AccessAuthVerifyInterceptor.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private Gson gson;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uid = (String) httpServletRequest.getAttribute(AppContext.KEY_ID);
        if (!StringUtils.isEmpty(uid)) {

            //查询用户所在用户组
            JsonResult jsonResultOfUserGroup = userGroupService.selectTheMaxUserGroupByUserId(uid);
            //获取最大权限的用户组
            Usergroup usergroup = (Usergroup) jsonResultOfUserGroup.getData().get(AppContext.KEY_DATA);
            //根据用户组id查询用户组所有的权限
            JsonResult jsonResultOfActions = actionService.selectActionByUserGroupId(usergroup.getId());
            if (jsonResultOfActions.getStatus() == 200) {
                JsonResult jsonResultOfAuth = actionService.verifyActions(Integer.valueOf(uid),
                            (List<String>) httpServletRequest.getAttribute(AppContext.KEY_ACTION));
                if (jsonResultOfAuth.getStatus() == 200) {
                    Map<String, Boolean> data = (Map<String, Boolean>) jsonResultOfAuth.getData().get(AppContext.KEY_DATA);
                    for(String key : data.keySet()) {
                        if (!data.get(key)) {
                            JsonResult jsonResult = new JsonResult();
                            jsonResult.setStatus(500);
                            jsonResult.setMessage("没有足够的权限：" + key);
                            return false;
                        }
                    }

                    return true;
                } else {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    httpServletResponse.getWriter().println(gson.toJson(jsonResultOfAuth));
                    return false;
                }
            } else {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.getWriter().println(gson.toJson(jsonResultOfActions));
                return false;
            }
        } else {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatus(500);
            jsonResult.setMessage("无效的用户");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            httpServletResponse.getWriter().println(gson.toJson(jsonResult));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
