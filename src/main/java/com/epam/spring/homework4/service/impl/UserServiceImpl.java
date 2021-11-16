package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.controller.dto.UserDto;
import com.epam.spring.homework4.controller.exception.UnknownDtoException;
import com.epam.spring.homework4.controller.mapper.Mapper;
import com.epam.spring.homework4.controller.mapper.MapperFactory;
import com.epam.spring.homework4.service.UserService;
import com.epam.spring.homework4.service.model.User;
import com.epam.spring.homework4.service.repository.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Repository<User, Integer> userRepository;

    @Override
    public UserDto get(Integer id) {
        log.info("getUser by id {}", id);
        User user = userRepository.get(id);
        return mapUserToUserDto(user);
    }


    @Override
    public List<UserDto> list() {
        log.info("get all users");
        return userRepository.getAll()
                .stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserDto userDto) {
        log.info("createUser with id {}", userDto.getId());
        User user = mapUserDtoToUser(userDto);
        user = userRepository.create(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto update(Integer id, UserDto userDto) {
        log.info("updateUser with id {}", id);
        User user = mapUserDtoToUser(userDto);
        user = userRepository.update(id, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void delete(Integer id) {
        log.info("deleteUser with id {}", id);
        userRepository.delete(id);
    }

    private UserDto mapUserToUserDto(User user) {
        return getMapper().toDto(user);
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return getMapper().toObject(userDto);
    }

    private Mapper<User, UserDto> getMapper() {
        Mapper<User, UserDto> mapper = null;
        try {
            mapper = MapperFactory.getMapper(new UserDto());
        } catch (UnknownDtoException e) {
            log.error("Error when mapping User to UserDto", e);
            throw new RuntimeException("Error when mapping User to UserDto", e);
        }
        return mapper;
    }
}

