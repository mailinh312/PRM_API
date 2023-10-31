package com.app.api.service;

import com.app.api.api.model.RegistrationBody;
import com.app.api.model.User;
import com.app.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegistrationBody registrationBody) {
        User user = new User();
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user.getPassword(), user.getAddress(), user.getPhone(), user.getId());
    }
}