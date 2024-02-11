package by.SpringBoot.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role {
    ADMIN, USER;


    public String getAuthority() {
        return name();
    }
}
