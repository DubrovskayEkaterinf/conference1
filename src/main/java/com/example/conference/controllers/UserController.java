package com.example.conference.controllers;

import com.example.conference.model.dto.request.UserInfoRequest;
import com.example.conference.model.dto.response.UserInfoResponse;
import com.example.conference.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

@PostMapping
    public UserInfoResponse creatUser(@RequestBody UserInfoRequest request) {
        return userService.creatUser(request);
    }

    @GetMapping("/{id}")
    public UserInfoResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @PutMapping("/{id}")
    public UserInfoResponse updateUser(@PathVariable Long id, @RequestBody UserInfoRequest request) {
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
    public void deletUser(@PathVariable Long id) {
        userService.deletUser(id);
    }
    @GetMapping("/all}")
    public List<UserInfoResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}
