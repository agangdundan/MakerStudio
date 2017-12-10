package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JwtUtils;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AccessTokenVerifyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String authorization = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            authorization = httpServletRequest.getParameter("token");
        }
        if (StringUtils.isEmpty(authorization)) {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatus(500);
            jsonResult.setMessage("您还未登录， 请先登录！");
            out.println(new Gson().toJson(jsonResult));
            out.flush();
            out.close();
            return false;
        } else {
            try {
                JwtUtils.parseJWT(authorization);
                httpServletRequest.setAttribute(AppContext.KEY_USER, JwtUtils.parseJWT2Uid(authorization));
            } catch (Exception ex) {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                JsonResult jsonResult = new JsonResult();
                jsonResult.setMessage("身份信息异常，请重新登录!");
                jsonResult.setStatus(500);
                out.println(new Gson().toJson(jsonResult));
                out.flush();
                out.close();
                return false;
            }
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
