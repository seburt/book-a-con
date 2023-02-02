package com.seburt.bookacon.api.controller;

import com.seburt.bookacon.api.dto.ConferenceDto;
import com.seburt.bookacon.core.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ConferenceController implements ConferenceApi{

    @Autowired
    private ConferenceService conferenceService;

    @Override
    public ResponseEntity<ConferenceDto> createConference(ConferenceDto dto) {

        val resp =
                conferenceService.createConference(dto.getHeadcount(), dto.getScheduleSlot(), dto.getOccupation());

        log.info("Conference is created: {}", resp);

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> getConferenceById(String id) {

        val resp =
                conferenceService.getConferenceById(id);

        log.info("Conference: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<List<ConferenceDto>> getConferences() {

        val resp =
                conferenceService.getAllConferences();

        log.info("Conferences: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> updateHeadcountById(String id, Integer headcount) {

        val resp =
                conferenceService.updateHeadcountById(id, headcount);

        log.info("Headcount updated for Conference: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> removeConference(String id) {

        val resp =
                conferenceService.removeConference(id);

        log.info("Conference removed: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> updateConference(String id, ConferenceDto conferenceDto) {

        val resp =
                conferenceService.updateConference(conferenceDto);

        log.info("Conference is updated: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
