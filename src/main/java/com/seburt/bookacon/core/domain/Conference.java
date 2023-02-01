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
    private ReservationsMap reservationsMap;

    // logic for creation
    // on creation - creates booking, if has a room
    // if not - Conf can't be created

    // update: if reserved, cannot have more participants than booked capacity
    //

    // reservation
}
