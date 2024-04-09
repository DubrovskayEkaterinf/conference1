package com.example.conference.service.impl;


import com.example.conference.Utils.PaginationUtil;
import com.example.conference.exceptions.CustomException;
import com.example.conference.model.db.entity.User;
import com.example.conference.model.db.repository.ConferenceRepo;
import com.example.conference.model.db.repository.UserRepo;
import com.example.conference.model.dto.request.UserInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.model.dto.response.UserInfoResponse;
import com.example.conference.model.enums.UserStatus;
import com.example.conference.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ObjectMapper mapper;
    private static final  String ERR_MSG = "User not found";


    private final ConferenceRepo conferenceRepo;


    @Override
    public UserInfoResponse creatUser(UserInfoRequest request) {
        String email = request.getEmail();

        if(!EmailValidator.getInstance().isValid(email)){
            throw  new CustomException("Invalid email", HttpStatus.BAD_REQUEST);
        }
        userRepo.findByEmail(request.getEmail())
                .ifPresent(user -> {throw new CustomException
                        ("Email already exists", HttpStatus.CONFLICT);}
                );

      User user = mapper.convertValue(request, User.class);
      user.setStatus(UserStatus.Created);
      user.setCreatedAt(LocalDateTime.now());
      userRepo.save(user);

        return mapper.convertValue(user, UserInfoResponse.class);
    }

    @Override
    public UserInfoResponse getUser(Long id) {

        return mapper.convertValue(getUserDb(id), UserInfoResponse.class);
    }

    @Override
    public User getUserDb(Long id) {
        return userRepo.findById(id)
                .orElseThrow(()-> new CustomException(ERR_MSG, HttpStatus.NOT_FOUND));
    }

    @Override
    public UserInfoResponse updateUser(Long id, UserInfoRequest request) {
       User user = getUserDb(id);

           user.setEmail(request.getEmail() == null ? user.getEmail() : request.getEmail());
           user.setPassword(request.getPassword() == null ? user.getPassword() : request.getPassword());
           user.setLastName(request.getLastName() == null ? user.getLastName() : request.getLastName());
           user.setFirstName(request.getFirstName() == null ? user.getFirstName() : request.getFirstName());
           user.setMiddleName(request.getMiddleName() == null ? user.getMiddleName() : request.getMiddleName());
           user.setAge(request.getAge() == null ? user.getAge() : request.getAge());
           user.setPhoneNumber(request.getPhoneNumber() == null ? user.getPhoneNumber() : request.getPhoneNumber());
           user.setSpecialization(request.getSpecialization() == null ? user.getSpecialization() : request.getSpecialization());
           user.setAcademicTitles(request.getAcademicTitles() == null ? user.getAcademicTitles() : request.getAcademicTitles());
           user.setSpeaker(request.getSpeaker() == null ? user.getSpeaker() : request.getSpeaker());

           user.setStatus(UserStatus.Update);
           user.setUpdateAt(LocalDateTime.now());
           userRepo.save(user);



        return mapper.convertValue(user, UserInfoResponse.class);
    }

    @Override
    public void deletUser(Long id) {
       User user = getUserDb(id);

           user.setStatus(UserStatus.Deleted);
           user.setUpdateAt(LocalDateTime.now());
           userRepo.save(user);

       }


    @Override
    public Page<UserInfoResponse> getAllUsers(Integer page, Integer perPage, String sort,
                                              Sort.Direction order) {
        Pageable request = PaginationUtil.detPageRequest(page, perPage, sort, order);
       List<UserInfoResponse> all = userRepo.findAll(request)
               .getContent()
               .stream()
                .map(user -> mapper.convertValue(user, UserInfoResponse.class))
                .collect(Collectors.toList());



        return  new PageImpl<>(all);
    }


    @Override
    public User updateConferenceList(User user) {
        return userRepo.save(user);

    }

    @Override
    public Page<ConferenceInfoResponse> getAllConferencesUser(Integer page, Integer perPage, String sort, Sort.Direction order) {

        Pageable request = PaginationUtil.detPageRequest(page, perPage, sort, order);

        List<ConferenceInfoResponse> all = conferenceRepo.findAll(request)
                .getContent()
                .stream()
                .map(conference -> mapper.convertValue(conference, ConferenceInfoResponse.class))
                .collect(Collectors.toList());

        return new PageImpl<>(all);
    }




}
