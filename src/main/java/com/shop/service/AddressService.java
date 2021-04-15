package com.shop.service;

import com.shop.domain.dto.AddressDTO;
import com.shop.domain.entity.Address;
import com.shop.domain.entity.User;
import com.shop.repository.AddressRepository;
import com.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressService {
    private final Logger logger = LoggerFactory.getLogger(AddressService.class);
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public AddressService(
            UserRepository userRepository,
            AddressRepository addressRepository
    ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public AddressDTO registerAddress(AddressDTO addressDTO) {
        Optional<User> findUser = userRepository.findById(addressDTO.getUserId());
        if (findUser.isPresent()) {
            User user = findUser.get();
            Address address = new Address();
            address.setName(addressDTO.getName());
            address.setBuyer(addressDTO.getBuyer());
            address.setAddress(addressDTO.getAddress());
            address.setDetail(addressDTO.getDetail());
            address.setPostcode(addressDTO.getPostcode());
            address.setTel(addressDTO.getTel());
            address.setUser(user);
            addressRepository.save(address);

            Set<Address> addresses = new HashSet<>(user.getAddresses());
            addresses.add(address);
            user.setAddresses(addresses);

            return new AddressDTO(address);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인을 해주세요");
        }
    }

    @Transactional
    public Set<AddressDTO> getAddressList(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isPresent()) {
            User user = findUser.get();
            Set<Address> addresses = user.getAddresses();
            Set<AddressDTO> addressDTOS = new HashSet<>();
            addresses.forEach(address -> {
                AddressDTO addressDTO = new AddressDTO(address);
                addressDTOS.add(addressDTO);
            });
            return addressDTOS;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인을 해주세요");
        }
    }
}
