package com.zweihander.navup.user.controllers;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zweihander.navup.user.domain.*;
import com.zweihander.navup.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.zweihander.navup.user.service.ItemService;


@RestController
public class UserController {

	@Autowired
	ItemService itemService;

//---------------------------------------------------------------------------------------------------
//								USER specific requests
//---------------------------------------------------------------------------------------------------
	// Method to retrieve user contact details, accepts 'username' from notification module request

	@RequestMapping(value = "/list/food", method = RequestMethod.GET)
	public List<ItemDTO> getFoodItems(){
		return itemService.getAllFoodItems();
	}

	@RequestMapping(value = "/list/clothing", method = RequestMethod.GET)
	public List<ItemDTO> getClothingItems(){
		return itemService.getAllClothingItems();
	}


	@RequestMapping(value = "/find/{id}" , method = RequestMethod.GET)
	public ItemDTO getItem(@PathVariable Long id){
		return  itemService.getItem(id);
	}


	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseDTO deleteItem(@PathVariable Long id){
		itemService.deleteItem(id);
		return new ResponseDTO("Item has been deleted");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseDTO addItem(@RequestBody ItemDTO dto){
		itemService.addItem(dto);
		return new ResponseDTO("Item has been added");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ItemDTO updateItem( @PathVariable Long id, @RequestBody ItemDTO dto){
		return  itemService.updateItem(id, dto);
	}


	@RequestMapping(value = "/add/special", method = RequestMethod.POST)
	public ItemDTO addSpecialToItem(@RequestBody ItemDTO dto){
		System.out.println("\n \n adding special to item \n " + dto + " \n \n");
		return itemService.addSpecialToItem(dto);
	}
}