package com.seburt.bookacon.api.service;

import com.seburt.bookacon.api.dto.ConferenceDto;
import com.seburt.bookacon.core.domain.DomainRoot;
import com.seburt.bookacon.core.repository.ConferenceRepo;
import com.seburt.bookacon.core.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceRepo conferenceRepo;

    @Autowired
    private DomainRoot confernceDomain;

    @Override
    public ConferenceDto createConference(Integer headcount, Integer scheduleSlot, Integer occupation) {

        // todo domain call -> repo call


        val result = confernceDomain.mockedConference(null, headcount, scheduleSlot, occupation);

        return result;
    }

    @Override
    public ConferenceDto getConferenceById(String id) {

        val result = confernceDomain.mockedConference(id, null, null, null);

        return result;
    }

    @Override
    public List<ConferenceDto> getAllConferences() {

        val result = List.of(confernceDomain.mockedConference(null, null, null, null));

        return result;
    }

    @Override
    public ConferenceDto updateHeadcountById(String id, Integer headcount) {

        val result = confernceDomain.mockedConference(id, headcount, null, null);

        return result;
    }

    @Override
    public ConferenceDto removeConference(String id) {

        val result = confernceDomain.mockedConference(id, null, null, null);

        return result;
    }

    @Override
    public ConferenceDto updateConference(ConferenceDto supplier) {

        val result = confernceDomain.mockedConference(supplier.getConferenceId(),
                supplier.getHeadcount(), supplier.getScheduleSlot(), supplier.getOccupation());

        return result;
    }
}
