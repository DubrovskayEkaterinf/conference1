package com.example.conference.service;

import com.example.conference.model.db.entity.Conference;
import com.example.conference.model.dto.request.ConferenceInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ConferenceService {

    ConferenceInfoResponse creatConference(ConferenceInfoRequest request);

    ConferenceInfoResponse getConference(Long id);

    ConferenceInfoResponse updateConference(Long id, ConferenceInfoRequest request);

    void deletConference(Long id);

    Page<ConferenceInfoResponse> getAllConferences(Integer page, Integer perPage, String sort, Sort.Direction order);


    ConferenceInfoResponse linkConferenceAndParticipant(Long userId, Long conferenceId);

    Conference getConferenceDb(Long Id);


    Page<ConferenceInfoResponse> getConferenceUserId(Long id, Integer page, Integer perPage, String sort, Sort.Direction order);

}
