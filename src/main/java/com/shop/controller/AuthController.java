package com.shop.controller;

import com.shop.domain.dao.User;
import com.shop.domain.dto.AuthDTO;
import com.shop.domain.dto.UserDTO;
import com.shop.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            path = "/login",
            method = RequestMethod.POST
    )
    public ResponseEntity<UserDTO> login(@RequestBody AuthDTO login) {
        UserDTO user = userService.login(login.getUsername(), login.getPassword());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/signup",
            method = RequestMethod.POST
    )
    public ResponseEntity<UserDTO> signup(@RequestBody AuthDTO signup) {
        UserDTO user = userService.signUp(signup.getUsername(), signup.getPassword());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
