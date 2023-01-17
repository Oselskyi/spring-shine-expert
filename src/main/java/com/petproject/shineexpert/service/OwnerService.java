package com.petproject.shineexpert.service;

import com.petproject.shineexpert.entity.Owner;

import java.util.List;

public interface OwnerService {

    Owner getById(Long ownerId);
    List<Owner> getAllOwners();
    Owner save(Owner owner);
    void deleteById(Long id);
}
