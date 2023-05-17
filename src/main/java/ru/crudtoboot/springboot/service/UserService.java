package ru.crudtoboot.springboot.service;

import ru.crudtoboot.springboot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    List<User> getAllUser();

    User getById(Long id);
}