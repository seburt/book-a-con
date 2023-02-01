package com.seburt.bookacon.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Custom ErrorResponse, utilizing the IETF devised RFC 7807
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(@ApiModelProperty("Internal identifier used for correlation purposes.")
                            @JsonProperty("debugId") String debugId,
                            @ApiModelProperty("Human readable, unique name of the error.")
                            @JsonProperty("title") String title,
                            @ApiModelProperty("The HTTP response code.")
                            @JsonProperty("status") String status,
                            @ApiModelProperty("Human-readable explanation of the error.")
                            @JsonProperty("detail") String detail) {
}