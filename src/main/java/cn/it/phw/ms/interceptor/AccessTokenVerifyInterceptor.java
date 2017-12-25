package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JwtUtils;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
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
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AccessTokenVerifyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String authorization = httpServletRequest.getHeader(AppContext.AUTHORIZATION);
        if (StringUtils.isEmpty(authorization)) {
            authorization = httpServletRequest.getParameter("token");
        }

        if (StringUtils.isEmpty(authorization)) {
            exportMsg(httpServletResponse, httpServletRequest, "您还未登陆，请先登录。");
            return false;
        } else {
            try {
                Claims claims = JwtUtils.parseJWT(authorization);

                if (redisTemplate.opsForHash().hasKey(AppContext.USER_CACHE, claims.getId())) {

                    String uid = claims.getId();

                    //验证通过
                    httpServletRequest.setAttribute(AppContext.KEY_ID, uid);
                    logger.info(httpServletRequest.getMethod() + ":" + httpServletRequest.getRequestURL().toString());
                    return true;
                } else {
                    exportMsg(httpServletResponse, httpServletRequest, "您还未登陆，请先登录。");
                    return false;
                }

            } catch (SignatureException | MalformedJwtException e) {
                exportMsg(httpServletResponse, httpServletRequest, "身份信息错误，请重新登录：" + e.getMessage());
                return false;
            } catch (ExpiredJwtException e) {
                exportMsg(httpServletResponse, httpServletRequest, "身份已过期，请重新登录。");
                return false;
            }
        }
    }

    private void exportMsg(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest, String message) throws IOException {

        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(500);
        jsonResult.setMessage(message);
        out.println(new Gson().toJson(jsonResult));
        out.flush();
        out.close();
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
