package com.seburt.bookacon.core.service;

import com.seburt.bookacon.api.dto.ConferenceDto;

import java.util.List;

public interface ConferenceService {

    ConferenceDto createConference(Integer headcount, Integer scheduleSlot, Integer occupation);

    ConferenceDto getConferenceById(String id);

    List<ConferenceDto> getAllConferences();

    ConferenceDto updateHeadcountById(String id, Integer headcount);

    ConferenceDto removeConference(String id);

    ConferenceDto updateConference(ConferenceDto conferenceDto);
}
