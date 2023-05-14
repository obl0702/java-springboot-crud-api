package com.ongbl.productrestapi.controllers;

import com.ongbl.productrestapi.entity.Item;
import com.ongbl.productrestapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/updateItems")
    public void updateItems(@RequestBody List<Item> items) {
        List<Long> ids = items.stream()
                .map(Item::getId)
                .collect(Collectors.toList());

        String status = "Annulled";
        itemRepository.updateItemsByIdIn(status, ids);
    }
}