package com.shop.controller;

import com.shop.domain.dto.ItemDTO;
import com.shop.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(
            ItemService itemService
    ) {
        this.itemService = itemService;
    }

    @RequestMapping(
            path = "",
            method = RequestMethod.GET
    )
    public ResponseEntity<Set<ItemDTO>> getItemList(@RequestHeader("userId") Long userId) {
        Set<ItemDTO> itemDTOS = itemService.getItemList(userId);
        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);
    }
}
