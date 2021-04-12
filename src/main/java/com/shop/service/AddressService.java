package com.shop.service;

import com.shop.domain.dao.Address;
import com.shop.domain.dao.User;
import com.shop.domain.dto.AddressDTO;
import com.shop.repository.AddressRepository;
import com.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class AddressService {
    private final Logger logger = LoggerFactory.getLogger(AddressService.class);
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

    @Transactional
//    public AddressDTO registerAddress(AddressDTO addressDTO) {
    public Optional<User> registerAddress(AddressDTO addressDTO) {
        Optional<User> findUser = userRepository.findById(addressDTO.getUserId());
        if (!findUser.isEmpty()) {
            User user = findUser.get();
            Address address = new Address(addressDTO);
            address.user = user;
            Set<Address> addressList = new HashSet<>();
            addressList.add(address);
//            user.addresses = addressList;
            addressRepository.save(address);
            userRepository.save(user);

//            return new AddressDTO(address);
            Optional<User> tempuser = userRepository.findWithAddressesById(addressDTO.getUserId());
            logger.info(tempuser.get().addresses.toString());
            logger.info(tempuser.toString());
            return tempuser;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "User Not Found"
            );
        }
    }
}
