package com.seburt.bookacon.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Data
@Builder
public class ReservationsMap {

    List<List<Conference>> conferenceByRoom;

}
