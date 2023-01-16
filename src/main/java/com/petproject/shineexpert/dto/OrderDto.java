package com.petproject.shineexpert.dto;

import com.petproject.shineexpert.entity.Services;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private String comment;
    private List<Long> serviceIds = new ArrayList<>();
}
