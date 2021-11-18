package com.epam.spring.homework4.controller.mapper;

import com.epam.spring.homework4.controller.dto.UserDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperUserTest {

    private Mapper<User, UserDto> mapper;
    private UserDto userDto;

    @BeforeEach
    void setUp() throws UnknownDtoException {
        userDto = new UserDto();
        mapper = MapperFactory.getMapper(userDto);
    }

    @Test
    void givenUserDto_whenToObject_thenUser() {
        userDto.setId(1);
        userDto.setName("test");
        userDto.setRoleId(1);
        userDto.setLocaleId(1);
        userDto.setActivated(true);
        User actual = mapper.toObject(userDto);

        User expected = User.builder()
                .id(1)
                .name("test")
                .roleId(1)
                .localeId(1)
                .activated(true)
                .build();

        assertEquals(expected, actual);
    }

    @Test
    void givenUser_whenToDto_thenUserDto() {
        User user = User.builder()
                .id(1)
                .name("test")
                .roleId(1)
                .activated(true)
                .localeId(1)
                .build();
        UserDto actual = mapper.toDto(user);

        UserDto expected = new UserDto();
        expected.setId(1);
        expected.setName("test");
        expected.setRoleId(1);
        expected.setLocaleId(1);
        expected.setActivated(true);

        assertEquals(expected, actual);
    }
}