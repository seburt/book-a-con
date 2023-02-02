package com.seburt.bookacon.core.domain;

import com.seburt.bookacon.api.dto.ConferenceDto;

public interface DomainRoot {

    ConferenceDto mockedConference(String id, Integer headcount, Integer scheduleSlot, Integer occupation);

}
