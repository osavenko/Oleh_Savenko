package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.BrandDto;
import com.epam.spring.homework4.service.model.Brand;

public class MapperBrand implements Mapper<Brand, BrandDto> {

    MapperBrand() {
    }

    @Override
    public Brand toObject(BrandDto dto) {
        return Brand.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public BrandDto toDto(Brand o) {
        BrandDto dto = new BrandDto();
        dto.setId(o.getId());
        dto.setName(o.getName());
        return dto;
    }
}
