package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.UserDto;
import com.epam.spring.homework4.service.model.User;

public class MapperUser implements Mapper<User, UserDto> {

    MapperUser() {
    }

    @Override
    public User toObject(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .roleId(dto.getRoleId())
                .localeId(dto.getLocaleId())
                .activated(dto.isActivated())
                .build();
    }

    @Override
    public UserDto toDto(User o) {
        UserDto dto = new UserDto();
        dto.setId(o.getId());
        dto.setName(o.getName());
        dto.setRoleId(o.getRoleId());
        dto.setLocaleId(o.getLocaleId());
        dto.setActivated(o.isActivated());
        return dto;
    }
}
