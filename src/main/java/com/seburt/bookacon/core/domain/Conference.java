package com.seburt.bookacon.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Conference aggregator
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conference {

    private String conferenceId;
    private int headcount;
    private int scheduleSlot;
    private Room room;
    private ReservationsGrid reservationsGrid;

    // todo business logic for conference reservation needs more details. To be discussed.
}
