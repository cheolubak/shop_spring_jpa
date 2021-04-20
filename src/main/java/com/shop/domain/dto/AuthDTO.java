package com.shop.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AuthDTO {
    @NotNull(message = "username은 필수입니다")
    @Pattern(
            regexp = "[a-zA-Z0-9]{2,20}",
            message = "username이 잘못되었습니다"
    )
    private String username;

    @NotNull(message = "비밀번호는 필수입니다")
    @Pattern(
            regexp = "[a-zA-Z0-9]{2,50}",
            message = "비밀번호가 잘못되었습니다"
    )
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
