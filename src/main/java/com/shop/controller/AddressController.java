package com.shop.controller;

import com.shop.domain.dto.AddressDTO;
import com.shop.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Set;

@RestController
@RequestMapping("addresses")
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

    @RequestMapping(
            path = "",
            method = RequestMethod.GET
    )
    public ResponseEntity<Set<AddressDTO>> getAddressList(@RequestHeader("userId") Long userId) {
        Set<AddressDTO> addressDTOS = addressService.getAddressList(userId);
        return new ResponseEntity<>(addressDTOS, HttpStatus.OK);
    }
}
