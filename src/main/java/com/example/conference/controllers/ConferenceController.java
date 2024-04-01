package com.example.conference.controllers;

import com.example.conference.model.dto.request.ConferenceInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conference")
@RequiredArgsConstructor

public class ConferenceController {
    private final ConferenceService conferenceService;

    @PostMapping
    public ConferenceInfoResponse creatConference(@RequestBody ConferenceInfoRequest request) {
        return conferenceService.creatConference(request);
    }

    @GetMapping("/{id}")
    public ConferenceInfoResponse getConference(@PathVariable Long id) {
        return conferenceService.getConference(id);
    }
    @PutMapping("/{id}")
    public ConferenceInfoResponse updateConference(@PathVariable Long id, @RequestBody ConferenceInfoRequest request) {
        return conferenceService.updateConference(id, request);
    }
    @DeleteMapping("/{id}")
    public void deletConference(@PathVariable Long id) {
        conferenceService.deletConference(id);
    }
    @GetMapping("/all}")
    public List<ConferenceInfoResponse> getAllConference() {
        return conferenceService.getAllConference();
    }



}
