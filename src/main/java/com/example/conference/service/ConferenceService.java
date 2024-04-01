package com.example.conference.service;

import com.example.conference.model.dto.request.ConferenceInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;

import java.util.List;

public interface ConferenceService {

    ConferenceInfoResponse creatConference(ConferenceInfoRequest request);

    ConferenceInfoResponse getConference(Long id);

    ConferenceInfoResponse updateConference(Long id, ConferenceInfoRequest request);

    void deletConference(Long id);

    List<ConferenceInfoResponse> getAllConference();
}
