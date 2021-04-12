package com.shop.service;

import com.shop.domain.dao.Address;
import com.shop.domain.dao.User;
import com.shop.domain.dto.AddressDTO;
import com.shop.repository.AddressRepository;
import com.shop.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class AddressService {
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressService(
            EntityManager entityManager,
            AddressRepository addressRepository,
            UserRepository userRepository
    ) {
        this.entityManager = entityManager;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public AddressDTO registerAddress(AddressDTO addressDTO) {
        Optional<User> findUser = userRepository.findById(addressDTO.getUserId());
        if (!findUser.isEmpty()) {
            User user = findUser.get();
            Address address = new Address(addressDTO);
            user.addresses.add(address);
            entityManager.persist(address);
            entityManager.persist(user);
            return new AddressDTO(address);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "User Not Found"
            );
        }
    }
}
