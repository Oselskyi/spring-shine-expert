package com.petproject.shineexpert.service;

import com.petproject.shineexpert.entity.Services;

import java.util.List;

public interface ServicesService {

    Services findById(Long id);
    List<Services> findAll();
    Services create(Services services);
    void deleteById(Long id);
    Services update(Long id, Services services);
}
