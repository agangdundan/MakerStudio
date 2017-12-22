package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.GroupmanagerMapper;
import cn.it.phw.ms.dao.mapper.UsergroupMapper;
import cn.it.phw.ms.pojo.*;
import cn.it.phw.ms.service.ActiongroupService;
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

    private ActiongroupService actiongroupService;

    @Autowired
    private Gson gson;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String uid = (String) httpServletRequest.getAttribute(AppContext.KEY_USER);
        if (!StringUtils.isEmpty(uid)) {

            //查询用户所在用户组
            JsonResult jsonResult = userGroupService.selectTheMaxUserGroupByUserId(uid);
            Usergroup usergroup = (Usergroup) jsonResult.getData().get(AppContext.KEY_DATA);
            
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
