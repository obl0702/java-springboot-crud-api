package com.ongbl.productrestapi.controllers;

import com.ongbl.productrestapi.entity.Item;
import com.ongbl.productrestapi.repositories.ItemRepository;
import com.ongbl.productrestapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://127.0.0.1:5173/")
public class ItemController {

    @Autowired
    ProductService productService;

    @PostMapping("/updateItems")
    public void updateItems(@RequestBody List<Long> id) {
        System.out.println(id);
        productService.updateItems(id);
    }
}