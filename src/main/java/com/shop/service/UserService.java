package com.shop.service;

import com.shop.domain.dto.UserDTO;
import com.shop.domain.entity.User;
import com.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(
            PasswordEncoder passwordEncoder,
            UserRepository userRepository
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public UserDTO login(String username, String password) {
        Optional<User> findUser = userRepository.findByUsername(username);
        if (findUser.isPresent()) {
            User user = findUser.get();
            if (checkPassword(user, password)) {
                return new UserDTO(user);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "아이디와 비밀번호를 확인해주세요.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다.");
        }
    }

    private Boolean checkPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    public UserDTO signUp(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return new UserDTO(user);
    }

}
