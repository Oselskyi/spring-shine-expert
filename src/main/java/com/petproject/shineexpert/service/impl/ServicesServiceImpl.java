package com.petproject.shineexpert.service.impl;

import com.petproject.shineexpert.entity.Services;
import com.petproject.shineexpert.repository.ServicesRepository;
import com.petproject.shineexpert.service.ServicesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {

    private final ServicesRepository servicesRepository;

    @Override
    public Services findById(Long id) {
        return servicesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    @Override
    public Services create(Services services) {
        return servicesRepository.save(services);
    }

    @Override
    public void deleteById(Long id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public Services update(Long id, Services services) {
        if (servicesRepository.findById(id).isPresent()){
            services.setId(id);
            servicesRepository.save(services);
        }

        return services;
    }
}
