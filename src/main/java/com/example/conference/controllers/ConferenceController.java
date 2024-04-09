package com.example.conference.controllers;

import com.example.conference.model.dto.request.ConferenceInfoRequest;
import com.example.conference.model.dto.response.ConferenceInfoResponse;
import com.example.conference.service.ConferenceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conferences")
@RequiredArgsConstructor

public class ConferenceController {
    private final ConferenceService conferenceService;


    @PostMapping
    @Operation(summary = "Создание мероприятия")
    public ConferenceInfoResponse creatConference(@RequestBody ConferenceInfoRequest request) {
        return conferenceService.creatConference(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение информации о мероприятии")
    public ConferenceInfoResponse getConference(@PathVariable Long id) {
        return conferenceService.getConference(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение информации о мероприятии")
    public ConferenceInfoResponse updateConference(@PathVariable Long id, @RequestBody ConferenceInfoRequest request) {
        return conferenceService.updateConference(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление мероприятия")
    public void deletConference(@PathVariable Long id) {
        conferenceService.deletConference(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Получение списка мероприятий")
    public Page<ConferenceInfoResponse> getAllConferences(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer perPage,
                                                          @RequestParam(defaultValue = "nameConference") String sort,
                                                          @RequestParam(defaultValue = "ASC") Sort.Direction order) {
        return conferenceService.getAllConferences(page, perPage, sort, order);
    }

    @PostMapping("/linkConferenceAndParticipant/{userId}/{conferenceId}")
    @Operation(summary = "Создание списка мероприятий пользователя")
    public ConferenceInfoResponse linkConferenceAndParticipant(@PathVariable Long userId, @PathVariable Long conferenceId) {

        return conferenceService.linkConferenceAndParticipant(userId, conferenceId);
    }


}
