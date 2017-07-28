package com.bellisimo.monolithic.controller;

import com.bellisimo.monolithic.domain.SpecialDTO;
import com.bellisimo.monolithic.service.SpecialService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by siphokazi on 2017/07/27.
 */
@RestController
@RequestMapping("/api/special")
public class SpecialController {

    @Inject
    SpecialService specialService;


    @PostMapping("/add")
    public HttpStatus add(@RequestBody SpecialDTO dto){
        specialService.add(dto);
        return HttpStatus.OK;
    }

    @PutMapping("/update")
    public HttpStatus update( @RequestBody SpecialDTO dto){
        specialService.update(dto);
        return  HttpStatus.OK;
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
    public HttpStatus deleteItem(@PathVariable Long id){
        specialService.delete(id);
        return HttpStatus.OK;
    }
}
