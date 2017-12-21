package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.GroupmanagerMapper;
import cn.it.phw.ms.dao.mapper.UsergroupMapper;
import cn.it.phw.ms.pojo.Groupmanager;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.pojo.Usergroup;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AccessAuthVerifyIntercepter implements HandlerInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(AccessAuthVerifyIntercepter.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private Gson gson;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uid = (String) httpServletRequest.getAttribute(AppContext.KEY_USER);
        if (!StringUtils.isEmpty(uid)) {

            //查询用户所在用户组
            JsonResult jsonResult = userGroupService.selectUserGroupByUserId(uid);
            if (jsonResult.getStatus() == 200) {
                Map<String, Object> data = jsonResult.getData();
                List<Groupmanager> groupmanagers = (List<Groupmanager>) data.get(AppContext.KEY_DATA);
                List<Integer> userGroupIds = new ArrayList<>();
                for (Groupmanager groupmanager : groupmanagers) {
                    userGroupIds.add(groupmanager.getUserGroupId());
                }
                //获取用户组拥有的权限
                for (Integer id : userGroupIds) {
                    logger.error(String.valueOf(id));
                }

            } else {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.getWriter().println(gson.toJson(jsonResult));
            }

        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
