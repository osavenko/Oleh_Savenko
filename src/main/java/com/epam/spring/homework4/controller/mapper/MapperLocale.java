package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.LocaleDto;
import com.epam.spring.homework4.service.model.Locale;

public class MapperLocale implements Mapper<Locale, LocaleDto> {

    MapperLocale() {
    }

    @Override
    public Locale toObject(LocaleDto dto) {
        return Locale.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public LocaleDto toDto(Locale o) {
        LocaleDto dto = new LocaleDto();
        dto.setId(o.getId());
        dto.setName(o.getName());
        dto.setDescription(o.getDescription());
        return dto;
    }
}
