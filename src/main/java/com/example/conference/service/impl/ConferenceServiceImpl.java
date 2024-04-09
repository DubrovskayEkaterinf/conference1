package com.example.conference.service.impl;

import com.example.conference.Utils.PaginationUtil;
import com.example.conference.exceptions.CustomException;
import com.example.conference.model.db.entity.Conference;
import com.example.conference.model.db.entity.User;
import com.example.conference.model.db.repository.ConferenceRepo;
import com.example.conference.model.dto.request.ConferenceInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.model.dto.response.UserInfoResponse;
import com.example.conference.model.enums.ConferenceStatus;
import com.example.conference.service.ConferenceService;
import com.example.conference.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepo conferenceRepo;
    private final ObjectMapper mapper;
    private final UserService userService;
    private static final  String ERR_MSG = "Conference not found";
    private Page<Conference> allByUserId;


    @Override
    public ConferenceInfoResponse creatConference(ConferenceInfoRequest request) {


        Conference conference = mapper.convertValue(request, Conference.class);
        conference.setStatus(ConferenceStatus.Created);
        conference.setCreatedAt(LocalDateTime.now());
        conferenceRepo.save(conference);

        return mapper.convertValue(conference, ConferenceInfoResponse.class);

    }

    @Override
    public ConferenceInfoResponse getConference(Long id) {
        return mapper.convertValue(getConferenceDb(id),
                ConferenceInfoResponse.class);
    }

    public Conference getConferenceDb(Long id) {
        return conferenceRepo.findById(id)
                .orElseThrow(()-> new CustomException(ERR_MSG, HttpStatus.NOT_FOUND));
    }




    @Override
    public Page<ConferenceInfoResponse> getConferenceUserId(Long id, Integer page, Integer perPage,
                                                            String sort, Sort.Direction order) {
        User userDb = userService.getUserDb(id);
        Pageable request = PaginationUtil.detPageRequest(page, perPage, sort, order);
        Page<Conference> allById = conferenceRepo.findById(request, id);

        return new PageImpl<>(allById.stream().
    map(conference -> mapper
            .convertValue(conference, ConferenceInfoResponse.class))
            .collect(Collectors.toList()));
    }







    @Override
    public ConferenceInfoResponse updateConference(Long id, ConferenceInfoRequest request) {
       Conference conference = getConferenceDb(id);

           conference.setNameConference(request.getNameConference() == null ?
                   conference.getNameConference(): request.getNameConference());
           conference.setDateEvent(request.getDateEvent() == null ?
                   conference.getDateEvent(): request.getDateEvent());
           conference.setTimeEvent(request.getTimeEvent() == null ?
                   conference.getTimeEvent(): request.getTimeEvent());
           conference.setCity(request.getCity() == null ? conference.getCity(): request.getCity());
           conference.setHouseNumber(request.getHouseNumber() == null ?
                   conference.getHouseNumber(): request.getHouseNumber());
           conference.setRoomNumber(request.getRoomNumber() == null ?
                   conference.getRoomNumber(): request.getRoomNumber());

            conference.setStatus(ConferenceStatus.Update);
            conference.setUpdateAt(LocalDateTime.now());
            conferenceRepo.save(conference);

        return mapper.convertValue(conference, ConferenceInfoResponse.class);
    }

    @Override
    public void deletConference(Long id) {
        Conference conference = getConferenceDb(id);

            conference.setStatus(ConferenceStatus.Deleted);
            conference.setUpdateAt(LocalDateTime.now());
            conferenceRepo.save(conference);


    }

    @Override
    public Page<ConferenceInfoResponse> getAllConferences(Integer page, Integer perPage, String sort, Sort.Direction order) {

        Pageable request = PaginationUtil.detPageRequest(page, perPage, sort, order);
        List<ConferenceInfoResponse> all = conferenceRepo.findAll(request)
                .getContent()
                .stream()
                .map(conference -> mapper.convertValue(conference, ConferenceInfoResponse.class))
                .collect(Collectors.toList());

        return new PageImpl<>(all);
    }







    @Override
    public ConferenceInfoResponse linkConferenceAndParticipant(Long userId, Long conferenceId) {
       Conference conference = getConferenceDb(conferenceId);
       User user = userService.getUserDb(userId);
       user.getConferences().add(conference);
       userService.updateConferenceList(user);

       conference.setUser(user);
       conference = conferenceRepo.save(conference);

        UserInfoResponse userInfoResponse = mapper.convertValue(user,
                UserInfoResponse.class);
        ConferenceInfoResponse conferenceInfoResponse = mapper.convertValue(conference,
                ConferenceInfoResponse.class);
        conferenceInfoResponse.setUser(userInfoResponse);



        return conferenceInfoResponse;
    }



}
