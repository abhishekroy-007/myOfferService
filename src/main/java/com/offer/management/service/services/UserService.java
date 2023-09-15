package com.offer.management.service.services;

import com.offer.management.service.entity.User;
import com.offer.management.service.exception.UserNotFoundException;
import com.offer.management.service.model.UserRequest;
import com.offer.management.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(UserRequest userRequest) {
        User user = User.builder()
                .phoneNumber(userRequest.getPhoneNumber())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .build();
        return userRepository.save(user);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);
        if(!user.isPresent()){
            throw new UserNotFoundException("User Not Found Exception");
        }
        return user.get();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
