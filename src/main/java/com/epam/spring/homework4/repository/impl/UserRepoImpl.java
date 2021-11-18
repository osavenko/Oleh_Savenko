package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserRepoImpl implements Repository<User, Integer> {

    private final List<User> users = new ArrayList<>();

    @Override
    public User get(Integer key) {
        return users.stream()
                .filter(user -> user.getId()==key)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public List<User> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(users));
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(Integer key, User user) {
        boolean isDeleted = users.removeIf(u -> u.getId()==key);
        if (isDeleted) {
            users.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public void delete(Integer key) {
        users.removeIf(user -> user.getId() == key);
    }
}
