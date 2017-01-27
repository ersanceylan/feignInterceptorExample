package com.kgblog.config;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ersanceylan on 23/01/2017.
 */
public class SecurityContextHystrixRequestVariableSetterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SecurityContextHystrixRequestVariable.getInstance().set(SecurityContextHolder.getContext());

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
