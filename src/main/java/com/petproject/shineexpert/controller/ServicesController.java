package com.petproject.shineexpert.controller;

import com.petproject.shineexpert.entity.Services;
import com.petproject.shineexpert.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/services")
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping("/{id}")
    public ResponseEntity<Services> findServiceById(@PathVariable Long id){
        Services service = servicesService.findById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Services>> findAllServices(){
        List<Services> services = servicesService.findAll();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Services service){
        Services savedService = servicesService.create(service);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Services> deleteService(@PathVariable Long id) {
        servicesService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
