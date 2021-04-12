package com.shop.domain.dto;

import com.shop.domain.dao.User;

import java.time.LocalDateTime;

public class UserDTO {
    public Long userId;
    public String username;
    public LocalDateTime updateAt;

    public UserDTO(User user) {
        this.userId = user.id;
        this.username = user.username;
        this.updateAt = user.updateAt;
    }
}
