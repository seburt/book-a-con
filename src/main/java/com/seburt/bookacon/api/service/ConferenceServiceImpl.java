package com.seburt.bookacon.api.service;

import com.seburt.bookacon.api.dto.ConferenceDto;
import com.seburt.bookacon.core.repository.ConferenceRepo;
import com.seburt.bookacon.core.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

    private ConferenceRepo conferenceRepo;

    @Override
    public ConferenceDto createConference(Integer headcount, Integer scheduleSlot, Integer occupation) {

        // todo domain call -> repo call

        val result = buildConference(null, headcount, scheduleSlot, occupation);

        return result;
    }

    @Override
    public ConferenceDto getConferenceById(String id) {

        val result = buildConference(id, null, null, null);

        return result;
    }

    @Override
    public List<ConferenceDto> getAllConferences() {

        val result = List.of(buildConference(null, null, null, null));

        return result;
    }

    @Override
    public ConferenceDto updateHeadcountById(String id, Integer headcount) {

        val result = buildConference(id, headcount, null, null);

        return result;
    }

    @Override
    public ConferenceDto removeConference(String id) {

        val result = buildConference(id, null, null, null);

        return result;
    }

    @Override
    public ConferenceDto updateConference(ConferenceDto supplier) {

        val result = buildConference(supplier.getConferenceId(),
                supplier.getHeadcount(), supplier.getScheduleSlot(), supplier.getOccupation());

        return result;
    }

    // mock Conference provider
    private ConferenceDto buildConference(String id, Integer headcount, Integer scheduleSlot, Integer occupation) {
        return ConferenceDto.builder()
                .conferenceId( id == null ? UUID.randomUUID().toString() : id)
                .headcount(headcount == null ? 200 : headcount)
                .scheduleSlot(scheduleSlot == null ? 202 : scheduleSlot)
                .occupation(occupation == null ? 101 : occupation)
                .build();
    }
}
