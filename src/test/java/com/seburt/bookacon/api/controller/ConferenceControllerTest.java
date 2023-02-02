package com.seburt.bookacon.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seburt.bookacon.api.dto.ConferenceDto;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.URL;

import static org.hamcrest.Matchers.hasItems;

@SpringBootTest
@AutoConfigureMockMvc
class ConferenceControllerTest {


    @Autowired
    private MockMvc mockMvc;
    private static ConferenceDto expectedConference;

    @BeforeAll
    static void initExpected() throws IOException {
        final ObjectMapper om = new ObjectMapper();
        expectedConference =
                om.readValue(new URL("file:src/test/resources/data/conference.json"), ConferenceDto.class);
    }

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void createConference() {
    }

    @Test
    void getConferenceById() {

        expectedConference.setConferenceId("32c465f3-6fec-4489-9de9-5a395108239e");

        RestAssuredMockMvc.given()
                .param("id", "32c465f3-6fec-4489-9de9-5a395108239e")
                .when()
                .get("/conference")
                .then().assertThat().body("headcount", hasItems(expectedConference.getHeadcount()));
    }

    @Test
    void getConferences() {

        RestAssuredMockMvc.given()
                .when()
                .get("/conference")
                .then().assertThat().body("$.size()", Matchers.equalTo(1));

    }

    @Test
    void updateHeadcountById() {
    }

    @Test
    void removeConference() {
    }

    @Test
    void updateConference() {
    }
}