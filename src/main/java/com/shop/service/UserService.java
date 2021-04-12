package com.shop.service;

import com.shop.domain.dao.User;
import com.shop.domain.dto.UserDTO;
import com.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserService(
            PasswordEncoder passwordEncoder,
            UserRepository userRepository,
            EntityManager entityManager
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    public UserDTO login(String username, String password) {
    }

    @Transactional()
    public UserDTO signUp(String username, String password) {
        User user = new User(
                username,
                passwordEncoder.encode(password)
        );
        userRepository.save(user);
        return new UserDTO(user);
    }

}
