package com.offer.management.service.controller;

import com.offer.management.service.entity.User;
import com.offer.management.service.model.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserController {
    @PostMapping("/v1/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest);

    @GetMapping("/v1/getUser")
    public ResponseEntity<User> getUserByPhone(@RequestParam String phoneNumber);

    @GetMapping("/v1/getAllUser")
    public ResponseEntity<List<User>> getAllUser();
}
