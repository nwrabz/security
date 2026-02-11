package org.wrabz.sec.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomEntryPoint
  implements AuthenticationEntryPoint {
    @Override
    public void commence(
            @NonNull HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @NonNull AuthenticationException e)
      throws IOException {
        httpServletResponse
                .addHeader("message", "Rajjab, good progress so far!");
        httpServletResponse
                .sendError(HttpStatus.UNAUTHORIZED.value());
    }
}
