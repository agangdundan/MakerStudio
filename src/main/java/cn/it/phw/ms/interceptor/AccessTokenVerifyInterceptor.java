package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.Authority;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JwtUtils;
import cn.it.phw.ms.service.ActionService;
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
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class AccessTokenVerifyInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Gson gson;

    @Autowired
    private ActionService actionService;

    private String uid;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        //Verify Actions 检查是否是HandlerMethod类型，若不是则直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> clazz = handlerMethod.getBeanType();
        Class<?> superClazz = handlerMethod.getBeanType().getSuperclass();
        Method method = handlerMethod.getMethod();
        if (clazz != null && method != null) {
            boolean isClazzAnnotation = clazz.isAnnotationPresent(Authority.class);
            boolean isMethodAnnotation = method.isAnnotationPresent(Authority.class);

            Authority authority = null;
            if (isMethodAnnotation) {
                authority = method.getAnnotation(Authority.class);
            } else if (isClazzAnnotation) {
                authority = clazz.getAnnotation(Authority.class);
            } else {
                authority = superClazz.getAnnotation(Authority.class);
            }

            if (authority != null) {

                switch (authority.value()) {
                    case Validate: {

                        JsonResult jsonResultOfLogin = verifyLogin(httpServletRequest, httpServletResponse);
                        if (jsonResultOfLogin.getStatus() == 500) {
                            exportJsonResult(httpServletResponse, jsonResultOfLogin);
                            return false;
                        }
                        JsonResult jsonResultOfAction = verifyAction(httpServletRequest.getRequestURL().toString(), uid, httpServletRequest.getMethod());
                        if (jsonResultOfAction.getStatus() == 500) {
                            exportJsonResult(httpServletResponse, jsonResultOfAction);
                            return false;
                        }
                        break;
                    }

                    case NoValidate: {
                        break;
                    }

                    case NoAuthority: {
                        JsonResult jsonResultOfLogin = verifyLogin(httpServletRequest, httpServletResponse);
                        if (jsonResultOfLogin.getStatus() == 500) {
                            exportJsonResult(httpServletResponse, jsonResultOfLogin);
                            return false;
                        }
                        break;
                    }

                }

            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }

    /**
     * Export Json Result
     * @param httpServletResponse
     * @param jsonResult
     * @throws IOException
     */
    private void exportJsonResult(HttpServletResponse httpServletResponse, JsonResult jsonResult) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.println(gson.toJson(jsonResult));
        out.flush();
        out.close();
    }

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws IOException
     */
    private JsonResult verifyLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        JsonResult jsonResult = new JsonResult();

        String authorization = httpServletRequest.getHeader(AppContext.AUTHORIZATION);
        if (StringUtils.isEmpty(authorization)) {
            authorization = httpServletRequest.getParameter("token");
        }

        if (StringUtils.isEmpty(authorization)) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("Error: Login First Please");
            exportJsonResult(httpServletResponse, jsonResult);
        } else {
            try {
                Claims claims = JwtUtils.parseJWT(authorization);
                uid = claims.getId();

                if (redisTemplate.opsForHash().hasKey(AppContext.USER_CACHE, uid)) {
                    httpServletRequest.setAttribute(AppContext.KEY_ID, uid);
                    logger.info(httpServletRequest.getMethod() + ":" + httpServletRequest.getRequestURL().toString());
                    jsonResult.setStatus(200);
                    jsonResult.setMessage("OK");
                } else {
                    jsonResult.setStatus(500);
                    jsonResult.setMessage("Error: Login First Please");
                }
            } catch (SignatureException | MalformedJwtException e) {
                jsonResult.setStatus(500);
                jsonResult.setMessage("Error: Login Error, Retry Please");
                return jsonResult;
            } catch (ExpiredJwtException e) {
                jsonResult.setStatus(500);
                jsonResult.setMessage("Error: Login Info Timed out");
                return jsonResult;
            }

        }

        return jsonResult;
    }

    /**
     *
     * @param url
     * @param uid
     * @return
     */
    private JsonResult verifyAction(String url, String uid, String type) {
        return actionService.verifyActions(Integer.valueOf(uid), url, type);
    }
}
