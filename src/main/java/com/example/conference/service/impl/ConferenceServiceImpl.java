package com.example.conference.service.impl;

import com.example.conference.model.dto.request.ConferenceInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ConferenceServiceImpl implements ConferenceService {
    @Override
    public ConferenceInfoResponse creatConference(ConferenceInfoRequest request) {
        return null;
    }

    @Override
    public ConferenceInfoResponse getConference(Long id) {
        return null;
    }

    @Override
    public ConferenceInfoResponse updateConference(Long id, ConferenceInfoRequest request) {
        return null;
    }

    @Override
    public void deletConference(Long id) {

    }

    @Override
    public List<ConferenceInfoResponse> getAllConference() {
        return null;
    }
}
