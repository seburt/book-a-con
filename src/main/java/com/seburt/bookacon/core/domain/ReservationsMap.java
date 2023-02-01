package com.seburt.bookacon.core.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
@Data
public class ReservationsMap {

    List<List<Conference>> conferenceByRoom;

}
