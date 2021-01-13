package com.ha.web;

import com.ha.item.pojo.Item;
import com.ha.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> saveItem(Item item){
        if(item.getPrice() == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        item = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
