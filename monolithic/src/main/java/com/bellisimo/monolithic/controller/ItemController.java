package com.bellisimo.monolithic.controller;

/*import com.bellisimo.monolithic.domain.Item;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.service.ItemService;*/
import com.bellisimo.monolithic.domain.Item;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.service.ItemService;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/*import javax.inject.Inject;
import java.util.List;*/

/**
 * Created by siphokazi on 2017/07/17.
 */
@RestController
@RequestMapping("/api/item")
public class ItemController  {

    @Inject
    ItemService itemService;

    @RequestMapping( value = "/add" , method = RequestMethod.POST)
    public ResponseEntity<ItemDTO> addItem(@RequestBody ItemDTO dto){
        ItemDTO result = itemService.addItem(dto);
        return ResponseEntity.ok(result);
    }

    /*@RequestMapping( value = "/update", method = RequestMethod.PUT)
    public HttpStatus updateItem( @RequestBody ItemDTO dto){

        return  HttpStatus.OK;
    }

    @RequestMapping( value = "/list" , method = RequestMethod.GET)
    public List<ItemDTO> getItems(){
        return itemService.getAllItems();
    }*/

}
