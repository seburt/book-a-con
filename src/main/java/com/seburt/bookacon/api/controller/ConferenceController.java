package com.seburt.bookacon.api.controller;

import com.seburt.bookacon.api.dto.ConferenceDto;
import com.seburt.bookacon.core.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ConferenceController implements ConferenceApi{

    private ConferenceService conferenceService;

    @Override
    public ResponseEntity<ConferenceDto> createConference(ConferenceDto conferenceDto) {

        val resp = ConferenceDto.builder()
                .build();

        log.info("Conference is created: {}", resp);

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> getConferenceById(String id) {

        val resp = ConferenceDto.builder()
                .build();

        log.info("Conference: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<List<ConferenceDto>> getConferences() {

        val resp = List.of(
                ConferenceDto.builder()
                .build());

        log.info("Conferences: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> updateHeadcountById(String id, Integer headcount) {

        val resp = ConferenceDto.builder()
                .build();

        log.info("Headcount updated for Conference: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> removeConference(String id) {

        val resp = ConferenceDto.builder()
                .build();

        log.info("Conference removed: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Override
    public ResponseEntity<ConferenceDto> updateConference(ConferenceDto conferenceDto) {

        val resp = ConferenceDto.builder()
                .build();

        log.info("Conference is updated: {}", resp);

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
