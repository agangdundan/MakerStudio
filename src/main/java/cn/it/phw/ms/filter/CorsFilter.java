package cn.it.phw.ms.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决跨域请求的拦截器
 * @author phw
 */
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Header", "Authentication");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
