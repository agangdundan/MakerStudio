package cn.it.phw.ms.interceptor;

import cn.it.phw.ms.common.Authority;
import cn.it.phw.ms.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class AuthorityAnnotationInterceptor implements HandlerInterceptor {

    @Autowired
    private ActionService actionService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {

            /**
             * handler为响应的参数
             */
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();


                if (clazz != null && method != null) {
                    boolean isClazzAnnotation = clazz.isAnnotationPresent(Authority.class);
                    boolean isMethodAnnotation = method.isAnnotationPresent(Authority.class);

                    Authority authority = null;

                    //如果方法和类中同时存在这个注解，那么方法中的注解回覆盖类中的注解
                    if (isMethodAnnotation) {
                        authority = method.getAnnotation(Authority.class);
                    } else if (isClazzAnnotation) {
                        authority = clazz.getAnnotation(Authority.class);
                    }

                    if (authority != null) {
                        switch (authority.value()) {

                            //验证权限
                            case Validate:
                                //actionService.verifyActions(httpServletRequest.getAttribute(AppContext.KEY_ID), )
                                break;

                            case NoValidate:
                                break;

                            case NoAuthority:

                                break;

                            default:
                                break;
                        }
                    }
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
