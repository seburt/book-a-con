package com.seburt.bookacon.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Data
@Builder
public class Conference {

    UUID conferenceId;
    int headcount;
    int scheduleSlot;
//    Map<Integer, Room> reservationSchedule;

    // validation
    // checks

    // logic for creation
    // on creation - creates booking, if has a room
    // if not - Conf can't be created

    // update: if reserved, cannot have more participants than booked capacity
    //

    // reservation
}
