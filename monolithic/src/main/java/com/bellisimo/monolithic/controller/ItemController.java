package com.bellisimo.monolithic.controller;

/*import com.bellisimo.monolithic.domain.Item;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.service.ItemService;*/
import com.bellisimo.monolithic.domain.Item;
import com.bellisimo.monolithic.domain.ItemDTO;
import com.bellisimo.monolithic.domain.ResponseDTO;
import com.bellisimo.monolithic.service.ItemService;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/*import javax.inject.Inject;
import java.util.List;*/

/**
 * Created by siphokazi on 2017/07/17.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/item")
public class ItemController  {

    @Inject
    ItemService itemService;


    @PostMapping("/add")
    public HttpStatus addItem(@RequestBody ItemDTO dto){
        itemService.addItem(dto);
        return HttpStatus.OK;
    }

    @PutMapping("/update/{id}")
    public ItemDTO updateItem( @PathVariable Long id, @RequestBody ItemDTO dto){
        return  itemService.updateItem(id, dto);
    }

    @GetMapping("/list")
    public List<ItemDTO> getItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/find/{id}")
    public ItemDTO getItem(@PathVariable Long id){
        return  itemService.getItem(id);
    }

    @DeleteMapping("/remove/{id}")
    public HttpStatus deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return HttpStatus.OK;
    }

    @PostMapping("/add/special")
    public ResponseDTO addSpecialToItem(@RequestBody ItemDTO dto){
        System.out.println("\n \n adding special to item \n " + dto + " \n \n");
        itemService.addSpecialToItem(dto);
        return new ResponseDTO("Special added successfully to item.");
    }

    @PutMapping("/remove/special/{itemId}")
    public HttpStatus removeSpecialFromItem(@PathVariable Long itemId){
        itemService.removeSpecialFromItem(itemId);
        return HttpStatus.OK;
    }

}
