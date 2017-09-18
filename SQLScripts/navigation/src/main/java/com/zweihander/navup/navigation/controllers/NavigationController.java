package com.zweihander.navup.navigation.controllers;

import java.util.LinkedList;
import java.util.List;

import com.zweihander.navup.navigation.domain.POI;
import com.zweihander.navup.navigation.service.NavigationService;
import com.zweihander.navup.navigation.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.zweihander.navup.navigation.domain.*;

@RestController
public class NavigationController
{
    @Autowired
    SpecialService specialService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody SpecialDTO dto){
        System.out.println("creating special");
        specialService.add(dto);
        return new ResponseDTO("The special was created successfully");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDTO update( @RequestBody SpecialDTO dto){
        specialService.update(dto);
        return  new ResponseDTO("The special was updated successfully");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SpecialDTO> list(){
        return specialService.getAll();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public SpecialDTO find(@PathVariable Long id){
        return  specialService.get(id);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseDTO deleteItem(@PathVariable Long id){
        specialService.delete(id);
        return new ResponseDTO("The special was deleted successfully");
    }

}
