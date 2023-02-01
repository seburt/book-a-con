package com.seburt.bookacon.api.exception;

import lombok.RequiredArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;

/**
 * Custom api error descriptor values
 */
@RequiredArgsConstructor
public enum ApiError {

    CUSTOM_BAD_REQUEST(
            Level.WARN,
            "VALIDATION_ERROR",
            HttpStatus.BAD_REQUEST,
            "Input parameters include invalid values."),
    CUSTOM_NOT_FOUND(
            Level.INFO,
            "RESOURCE_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "The resource does not exist."),
    CUSTOM_UNPROCESSABLE_ENTITY(
            Level.WARN,
            "UNPROCESSABLE_ENTITY",
            HttpStatus.UNPROCESSABLE_ENTITY,
            "Unprocessable entity provided."),
    CUSTOM_INTERNAL_SERVER_ERROR(
            Level.ERROR,
            "INTERNAL_SERVER_ERROR",
            HttpStatus.INTERNAL_SERVER_ERROR,
            "The server encountered an unexpected condition that prevented it from fulfilling the request.");


    public final Level logLevel;
    public final String title;
    public final HttpStatus status;
    public final String detail;

}
