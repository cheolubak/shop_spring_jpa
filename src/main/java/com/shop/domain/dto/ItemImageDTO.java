package com.shop.domain.dto;

import com.shop.domain.entity.ItemImage;

public class ItemImageDTO {
    private Long id;
    private String path;

    public ItemImageDTO(ItemImage image) {
        id = image.getId();
        path = image.getPath();
    }
}
