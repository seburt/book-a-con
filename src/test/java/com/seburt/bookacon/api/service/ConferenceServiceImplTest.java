package com.seburt.bookacon.api.service;

import com.seburt.bookacon.core.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConferenceServiceImplTest {

    @Autowired
    private ConferenceService conferenceService;

    @Test
    void createConference() {

       var expected =  conferenceService.createConference(100, 202, 202);

        assertEquals(expected, expected);

    }
}