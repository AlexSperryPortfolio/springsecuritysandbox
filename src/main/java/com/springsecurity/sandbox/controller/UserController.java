package com.springsecurity.sandbox.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springsecurity.sandbox.domain.User;
import com.springsecurity.sandbox.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/user/getById")
    public ResponseEntity getUserById(HttpServletRequest request, @RequestBody String inputBody) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode input = objectMapper.readTree(inputBody);
        int userId = input.get("userId").asInt();
        User user = userRepository.findOne(userId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
