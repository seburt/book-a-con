package com.seburt.bookacon.core.domain;

import com.seburt.bookacon.api.dto.ConferenceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Conference aggregator
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conference implements DomainRoot {

    private String conferenceId;
    private int headcount;
    private int scheduleSlot;
    private Room room;
    private ReservationsGrid reservationsGrid;

    // todo business logic for conference reservation needs more details. To be discussed.


    @Override
    public ConferenceDto mockedConference(String id, Integer headcount, Integer scheduleSlot, Integer occupation) {
        return ConferenceDto.builder()
                .conferenceId(id == null ? UUID.randomUUID().toString() : id)
                .headcount(headcount == null ? 200 : headcount)
                .scheduleSlot(scheduleSlot == null ? 202 : scheduleSlot)
                .occupation(occupation == null ? 101 : occupation)
                .build();
    }
}
