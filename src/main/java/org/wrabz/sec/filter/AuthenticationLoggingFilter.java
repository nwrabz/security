package org.wrabz.sec.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) request;
        var requestId =
                httpRequest.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id " +  requestId);

                chain.doFilter(request, response);
    }
}
