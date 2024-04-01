package com.example.conference.service;

import com.example.conference.model.dto.request.UserInfoRequest;
import com.example.conference.model.dto.response.UserInfoResponse;

import java.util.List;

public interface UserService {
    UserInfoResponse creatUser(UserInfoRequest request);

    UserInfoResponse getUser(Long id);

    UserInfoResponse updateUser(Long id, UserInfoRequest request);

    void deletUser(Long id);

    List<UserInfoResponse> getAllUsers();
}
