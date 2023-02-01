package com.seburt.bookacon.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Represents Conference business object, holding conference, participants and related reservation details.
 */
@Builder
@Data
@AllArgsConstructor
@ApiModel(description = "Represents Conference business object, holding conference, participants and related reservation details.")
public class ConferenceDto {

    /**
     * Conference unique identifier
     */
    @ApiModelProperty(example = "uuid-ddf4f", required = true, value = "Conference unique identifier")
    @NotNull
    @JsonProperty("conferenceId")
    private String conferenceId;

    /**
     * Number of participants
     */
    @ApiModelProperty(example = "202", required = true, value = "Number of participants")
    @NotNull
    @Valid
    @JsonProperty("headcount")
    private Integer headcount;

    /**
     * Represents a notional schedule unit of Conference duration, that is one calendar day. Same as day number in a year.
     *
     */
    @ApiModelProperty(example = "213", required = true, value = "Represents a notional schedule unit of Conference duration, that is one calendar day. Same as day number in a year.")
    @NotNull
    @Valid
    @JsonProperty("scheduleSlot")
    private Integer scheduleSlot;

    /**
     * Room identifier, where conference is reserved to take place.
     */
    @ApiModelProperty(example = "101", required = true, value = "Room identifier, where conference is reserved to take place.")
    @NotNull
    @Valid
    @JsonProperty("occupation")
    private Integer occupation;

}
