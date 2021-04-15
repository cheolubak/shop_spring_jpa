package com.shop.domain.dto;

import com.shop.domain.entity.User;

import java.time.LocalDateTime;

public class UserDTO {
    private Long userId;
    private String username;
    private LocalDateTime updateAt;

    public UserDTO() {
    }

    public UserDTO(User user) {
        userId = user.getId();
        username = user.getUsername();
        updateAt = user.getUpdateAt();
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
}
