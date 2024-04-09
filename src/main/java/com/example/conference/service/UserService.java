package com.example.conference.service;

import com.example.conference.model.db.entity.User;
import com.example.conference.model.dto.request.UserInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.model.dto.response.UserInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface UserService {
    UserInfoResponse creatUser(UserInfoRequest request);

    UserInfoResponse getUser(Long id);

    User getUserDb(Long id);

    UserInfoResponse updateUser(Long id, UserInfoRequest request);

    void deletUser(Long id);

    Page<UserInfoResponse> getAllUsers(Integer page, Integer perPage, String sort,
                                       Sort.Direction order);



    User updateConferenceList(User user);


    Page<ConferenceInfoResponse> getAllConferencesUser(Integer page, Integer perPage, String sort, Sort.Direction order);
}
