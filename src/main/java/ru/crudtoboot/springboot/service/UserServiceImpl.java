package ru.crudtoboot.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crudtoboot.springboot.repositories.UserRepository;
import ru.crudtoboot.springboot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}