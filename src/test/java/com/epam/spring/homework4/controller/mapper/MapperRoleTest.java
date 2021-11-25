package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.RoleDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperRoleTest {

    private Mapper<Role, RoleDto> mapper;
    private RoleDto roleDto;

    @BeforeEach
    void setUp() throws UnknownDtoException {
        roleDto = new RoleDto();
        mapper = MapperFactory.getMapper(roleDto);
    }

    @Test
    void givenRoleDto_whenToObject_thenRole() {
        roleDto.setId(1);
        roleDto.setName("Admin");

        Role actual = mapper.toObject(roleDto);

        Role expected = new Role();
        expected.setId(1);
        expected.setName("Admin");
        assertEquals(expected, actual);
    }

    @Test
    void givenRole_whenToDto_thenRoleDto() {
        Role role = new Role();
                role.setId(1);
                role.setName("Admin");
        RoleDto expected = mapper.toDto(role);

        RoleDto actual = new RoleDto();
        actual.setId(1);
        actual.setName("Admin");

        assertEquals(expected, actual);
    }
}