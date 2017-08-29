package com.bellisimo.monolithic.controller;

import com.bellisimo.monolithic.domain.ResponseDTO;
import com.bellisimo.monolithic.domain.SpecialDTO;
import com.bellisimo.monolithic.service.SpecialService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by siphokazi on 2017/07/27.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/special")
public class SpecialController {

    @Inject
    SpecialService specialService;


    @PostMapping("/add")
    public ResponseDTO add(@RequestBody SpecialDTO dto){

        specialService.add(dto);
        return new ResponseDTO("The special was created successfully");
    }

    @PutMapping("/update")
    public ResponseDTO update( @RequestBody SpecialDTO dto){
        specialService.update(dto);
        return  new ResponseDTO("The special was updated successfully");
    }

    @GetMapping("/list")
    public List<SpecialDTO> list(){
        return specialService.getAll();
    }

    @GetMapping("/find/{id}")
    public SpecialDTO find(@PathVariable Long id){
        return  specialService.get(id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseDTO deleteItem(@PathVariable Long id){
        specialService.delete(id);
        return new ResponseDTO("The special was deleted successfully");
    }
}
