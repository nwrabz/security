package org.wrabz.sec.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestValidationFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String requestId = httpRequest.getHeader("Request-Id");

        if (requestId == null || requestId.isEmpty()) {
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        chain.doFilter(request, response);
    }
}
