package com.app.api.service;

import com.app.api.api.model.RegistrationBody;
import com.app.api.model.User;
import com.app.api.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JWTService jwtService;

    public UserService(UserRepository userRepository,
                       JWTService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public User register(@NotNull User user) throws Exception {
        if (userRepository.findByUsernameIgnoreCase(user.getUsername()).isPresent()) {
            throw new Exception();
        }
        else {
            return userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            return jwtService.generateJWT(user);
        }
        return null;

    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user.getPassword(), user.getAddress(), user.getPhone(), user.getId());
    }
}