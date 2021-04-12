package com.shop.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AuthDTO {
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{2,20}")
    private String username;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{2,50}")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
