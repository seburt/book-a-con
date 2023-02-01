package com.seburt.bookacon.api.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.event.Level;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

import static com.seburt.bookacon.api.exception.ApiError.*;
import static net.logstash.logback.argument.StructuredArguments.keyValue;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

/**
 * Customizable error handler
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public final class ErrorHandler {

    /**
     * 400 status producer
     *
     * @see ResponseEntityExceptionHandler
     */
    @ExceptionHandler({
            MissingServletRequestParameterException.class,
            ServletRequestBindingException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            MissingServletRequestPartException.class,
            MethodArgumentNotValidException.class,
            BindException.class,
            ConstraintViolationException.class
    })
    public ResponseEntity<ErrorResponse> doBadRequest(Exception exception) {
        return processError(CUSTOM_BAD_REQUEST, exception);
    }

    /**
     * 404 status producer
     *
     * @see ResponseEntityExceptionHandler
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> doNotFound(Exception exception) {
        return processError(CUSTOM_NOT_FOUND, exception);
    }


    /**
     * 422 status producer
     *
     * @see ResponseEntityExceptionHandler
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> doUnsupportedMediaType(Exception exception) {
        return processError(CUSTOM_UNPROCESSABLE_ENTITY, exception);
    }

    /**
     * 500 status producer
     *
     * @see ResponseEntityExceptionHandler
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> doInternalServerError(Exception exception) {
        return processError(CUSTOM_INTERNAL_SERVER_ERROR, exception);
    }

    private ResponseEntity<ErrorResponse> processError(
            ApiError apiError,
            Exception exception) {
        return processError(apiError.status, apiError, exception);
    }


    private ResponseEntity<ErrorResponse> processError(
            HttpStatus httpStatus,
            ApiError apiError,
            Exception exception) {
        val responseEntity = buildResponseEntity(httpStatus, apiError);
        logError(apiError.logLevel, responseEntity.getBody(), exception);
        return responseEntity;
    }


    private ResponseEntity<ErrorResponse> buildResponseEntity(
            HttpStatus httpStatus,
            ApiError apiError) {
        val error = new ErrorResponse(
                generateId(),
                apiError.title,
                apiError.status.toString(),
                apiError.detail);
        return ResponseEntity.status(httpStatus).body(error);
    }

    private void logError(Level level, ErrorResponse response, Exception exception) {
        val message = buildMessage(response, exception);
        switch (level) {
            case TRACE -> log.trace(message, exception);
            case INFO -> log.info(message, exception);
            case WARN -> log.warn(message, exception);
            case ERROR -> log.error(message, exception);
            default -> log.debug(message, exception);
        }
    }

    private String buildMessage(ErrorResponse response, Exception exception) {
        return String.format("[%s] --> %s, %s",
                this.getClass().getSimpleName(),
                keyValue("message", exception.getLocalizedMessage()),
                keyValue("response", ReflectionToStringBuilder.toString(response, SHORT_PREFIX_STYLE)));
    }

    private String generateId(){
        // may contain custom id generation logic
        return UUID.randomUUID().toString();
    }

}
