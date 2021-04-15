package com.shop.service;

import com.shop.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final Logger logger = LoggerFactory.getLogger(AddressService.class);
    private final AddressRepository addressRepository;

    public AddressService(
            AddressRepository addressRepository
    ) {
        this.addressRepository = addressRepository;
    }

//    public AddressDTO registerAddress(AddressDTO addressDTO) {
//    }
}
