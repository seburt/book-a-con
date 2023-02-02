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

import static org.hamcrest.Matchers.equalTo;

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

        expectedConference.setHeadcount(200);

        RestAssuredMockMvc.given()
                .header("Content-Type", "application/json")
                .body(expectedConference)
                .when()
                .post("/conference")
                .then().assertThat().body("headcount", equalTo(200));

    }

    @Test
    void getConferenceById() {

        expectedConference.setConferenceId("32c465f3-6fec-4489-9de9-5a395108239e");

        RestAssuredMockMvc.given()
                .when()
                .get("/conference/32c465f3-6fec-4489-9de9-5a395108239e")
                .then().assertThat().body("headcount", equalTo(200));
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

        expectedConference.setHeadcount(130);

        RestAssuredMockMvc.given()
                .header("Content-Type", "application/json")
                .param("headcount", "130")
                .when()
                .put("/conference/32c465f3-6fec-4489-9de9-5a395108239e")
                .then().assertThat().body("headcount", equalTo(expectedConference.getHeadcount()));

    }

    @Test
    void removeConference() {

        RestAssuredMockMvc.given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/conference/32c465f3-6fec-4489-9de9-5a395108239e")
                .then().assertThat().body("headcount", equalTo(200));
    }

    @Test
    void updateConference() {

        expectedConference.setConferenceId("32c465f3-6fec-4489-9de9-5a395108239e");
        expectedConference.setScheduleSlot(130);

        RestAssuredMockMvc.given()
                .header("Content-Type", "application/json")
                .body(expectedConference)
                .when()
                .post("/conference/32c465f3-6fec-4489-9de9-5a395108239e")
                .then().assertThat().body("scheduleSlot", equalTo(expectedConference.getScheduleSlot()));

    }
}