package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.controller.dto.UserDto;
import com.epam.spring.homework4.service.CashMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class UserController {

    private final CashMachineService<UserDto, Integer> userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user")
    public List<UserDto> getAllUsers() {
        return userService.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{id}")
    public UserDto getUser(@PathVariable("id") @Min(1) int id) {
        return userService.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{id}")
    public UserDto updateUser(@PathVariable("id") @Min(1) int id, @Valid @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") @Min(1) int id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
