package org.wrabz.sec;

import org.springframework.security.core.Authentication;

import java.io.Serializable;

public interface SecurityContext extends Serializable {
    Authentication getAuthentication();
    void setAuthentication(Authentication authentication);
}
