package com.shop.service;

import com.shop.domain.dto.ItemDTO;
import com.shop.domain.entity.Item;
import com.shop.domain.entity.User;
import com.shop.repository.ItemImageRepository;
import com.shop.repository.ItemRepository;
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
public class ItemService {
    private final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ItemImageRepository itemImageRepository;

    public ItemService(
            UserRepository userRepository,
            ItemRepository itemRepository,
            ItemImageRepository itemImageRepository
    ) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.itemImageRepository = itemImageRepository;
    }

    @Transactional
    public Set<ItemDTO> getItemList(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isPresent()) {
            User user = findUser.get();
            Set<Item> items = user.getItems();
            Set<ItemDTO> itemDTOS = new HashSet<>();
            items.forEach(item -> {
                ItemDTO itemDTO = new ItemDTO(item);
                itemDTOS.add(itemDTO);
            });
            return itemDTOS;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

//    public ItemDTO registerItem(Long userId, ItemDTO itemDTO) {
//        Optional<User> findUser = userRepository.findById(userId);
//    }
}
