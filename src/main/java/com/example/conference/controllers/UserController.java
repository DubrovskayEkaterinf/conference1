package com.example.conference.controllers;

import com.example.conference.model.dto.request.UserInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.model.dto.response.UserInfoResponse;
import com.example.conference.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

@PostMapping
@Operation(summary = "Создание пользователя")
    public UserInfoResponse creatUser(@RequestBody @Valid UserInfoRequest request) {
        return userService.creatUser(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя")
    public UserInfoResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Изменение пользователя")
    public UserInfoResponse updateUser(@PathVariable Long id, @RequestBody @Valid UserInfoRequest request) {
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление пользователя")
    public void deletUser(@PathVariable Long id) {
        userService.deletUser(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Получение всех пользователей")
    public Page<UserInfoResponse> getAllUsers(@RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer perPage,
                                              @RequestParam(defaultValue = "firstName") String sort,
                                              @RequestParam(defaultValue = "ASC") Sort.Direction order){
        return userService.getAllUsers(page, perPage, sort, order);
    }

    @GetMapping("/allConferencesUser")
    @Operation(summary = "Получение всех конференций с участниками")
    public Page<ConferenceInfoResponse> getAllConferencesUser(@RequestParam(defaultValue = "1") Integer page,
                                                              @RequestParam(defaultValue = "10") Integer perPage,
                                                              @RequestParam(defaultValue = "firsName") String sort,
                                                              @RequestParam(defaultValue = "ASС") Sort.Direction order) {
        return userService.getAllConferencesUser(page, perPage, sort, order);
    }


}
