package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.LocaleDto;
import com.epam.spring.homework4.model.Locale;

public class MapperLocale implements Mapper<Locale, LocaleDto> {

    MapperLocale() {
    }

    @Override
    public Locale toObject(LocaleDto dto) {
        Locale locale = new Locale();
        locale.setId(dto.getId());
        locale.setName(dto.getName());
        locale.setDescription(dto.getDescription());
        return locale;
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
