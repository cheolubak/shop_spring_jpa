package com.shop.domain.dto;

import com.shop.domain.entity.Item;
import com.shop.domain.entity.ItemImage;

import java.util.HashSet;
import java.util.Set;

public class ItemDTO {
    private Long id;
    private String name;
    private Integer price;
    private Integer count;
    private String description;
    private Set<ItemImageDTO> images;

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        id = item.getId();
        name = item.getName();
        price = item.getPrice();
        count = item.getCount();
        description = item.getDescription();
        Set<ItemImage> images = item.getImages();
        Set<ItemImageDTO> imageDTOS = new HashSet<>();
        images.forEach(itemImage -> {
            ItemImageDTO imageDTO = new ItemImageDTO(itemImage);
            imageDTOS.add(imageDTO);
        });
        this.images = imageDTOS;
    }
}
