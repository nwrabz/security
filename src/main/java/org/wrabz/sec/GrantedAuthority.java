package org.wrabz.sec;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {
    String getAuthority();
}
