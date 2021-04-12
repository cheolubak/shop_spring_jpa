package com.shop.controller;

import com.shop.domain.dto.AddressDTO;
import com.shop.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(
            AddressService addressService
    ) {
        this.addressService = addressService;
    }

    @RequestMapping(
            path = "",
            method = RequestMethod.POST
    )
    public ResponseEntity<AddressDTO> registerAddress(@RequestBody AddressDTO address) {
        AddressDTO addressDTO = addressService.registerAddress(address);
        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
    }
}
