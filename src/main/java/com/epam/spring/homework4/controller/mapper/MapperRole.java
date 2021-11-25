package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.RoleDto;
import com.epam.spring.homework4.model.Role;

public class MapperRole implements Mapper<Role, RoleDto> {

    MapperRole() {
    }

    @Override
    public Role toObject(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }

    @Override
    public RoleDto toDto(Role o) {
        RoleDto dto = new RoleDto();
        dto.setId(o.getId());
        dto.setName(o.getName());
        return dto;
    }
}
