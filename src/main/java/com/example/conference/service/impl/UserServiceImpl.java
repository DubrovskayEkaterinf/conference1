package com.example.conference.service.impl;

import com.example.conference.model.dto.request.UserInfoRequest;
import com.example.conference.model.dto.response.UserInfoResponse;
import com.example.conference.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {
    @Override
    public UserInfoResponse creatUser(UserInfoRequest request) {
        return null;
    }

    @Override
    public UserInfoResponse getUser(Long id) {
        return null;
    }

    @Override
    public UserInfoResponse updateUser(Long id, UserInfoRequest request) {
        return null;
    }

    @Override
    public void deletUser(Long id) {

    }

    @Override
    public List<UserInfoResponse> getAllUsers() {
        return null;
    }
}
