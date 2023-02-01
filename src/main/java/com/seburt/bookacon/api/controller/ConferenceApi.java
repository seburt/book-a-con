package com.seburt.bookacon.api.controller;

import com.seburt.bookacon.api.dto.ConferenceDto;
import com.seburt.bookacon.api.exception.ErrorResponse;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@Api(value = "conference")
public interface ConferenceApi {

    /**
     * POST /conference : create Conference
     * Creates a new Conference and reservation for it
     *
     * @param conferenceDto (required)
     * @return OK (status code 200)
     * or Bad Request issue will produce this response. (status code 400)
     * or Unprocessable Entity issue will produce this response. (status code 422)
     * or Internal Server Error issue will produce this response. (status code 500)
     */
    @ApiOperation(
            value = "create Conference", nickname = "createConference", notes = "Creates a new Conference and reservation for it", response = ConferenceDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ConferenceDto.class),
            @ApiResponse(code = 400, message = "Bad Request issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error issue will produce this response.", response = ErrorResponse.class)})
    @PostMapping(
            value = "/conference",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<ConferenceDto> createConference(@ApiParam(value = "Conference dto", required = true) @Valid @RequestBody ConferenceDto conferenceDto);


    /**
     * GET /conference/{id} : get Conference by id.
     * Retrieves Conference by id.
     *
     * @param id Conference id (required)
     * @return OK (status code 200)
     * or Resource not found issue will produce this response. (status code 404)
     * or Internal Server Error issue will produce this response. (status code 500)
     */
    @ApiOperation(value = "get Conference by id.", nickname = "getConferenceById", notes = "Retrieves Conference by id.", response = ConferenceDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ConferenceDto.class),
            @ApiResponse(code = 404, message = "Resource not found issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error issue will produce this response.", response = ErrorResponse.class)})
    @GetMapping(
            value = "/conference/{id}",
            produces = {"application/json"}
    )
    ResponseEntity<ConferenceDto> getConferenceById(@PathVariable("id") @ApiParam(value = "Conference id", required = true) String id);


    /**
     * GET /conference : retrieve all  Conferences
     * Returns the list of Conferences
     *
     * @return OK (status code 200)
     * or Bad Request issue will produce this response. (status code 400)
     * or Internal Server Error issue will produce this response. (status code 500)
     */
    @ApiOperation(value = "retrieve all  Conferences", nickname = "getConferences", notes = "Returns the list of Conferences", response = ConferenceDto.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ConferenceDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error issue will produce this response.", response = ErrorResponse.class)})
    @GetMapping(
            value = "/conference",
            produces = {"application/json"}
    )
    ResponseEntity<List<ConferenceDto>> getConferences();

    /**
     * DELETE /conference/{id} : remove Conference
     * Removes existing Conference by id
     *
     * @param id Conference identifier (required)
     * @return removed Conference object (status code 200)
     * or Bad Request issue will produce this response. (status code 400)
     * or Resource not found issue will produce this response. (status code 404)
     * or Internal Server Error issue will produce this response. (status code 500)
     */
    @ApiOperation(value = "remove Conference", nickname = "removeConference", notes = "Removes existng Conference by id", response = ConferenceDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "removed Conference object", response = ConferenceDto.class),
            @ApiResponse(code = 400, message = "Bad Request issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Resource not found issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error issue will produce this response.", response = ErrorResponse.class)})
    @DeleteMapping(
            value = "/conference/{id}",
            produces = {"application/json"}
    )
    ResponseEntity<ConferenceDto> removeConference(@PathVariable("id") @ApiParam(value = "Conference identifier", required = true) String id);

    /**
     * PUT /conference/{id} : update headcount of Conference
     * Updates headcount for existing Conference by id providing a value for headcount property.
     *
     * @param id        Conference id (required)
     * @param headcount Value for headcount property of Conference (required)
     * @return OK (status code 200)
     * or Resource not found issue will produce this response. (status code 404)
     * or Bad Request issue will produce this response. (status code 400)
     * or Unprocessable Entity issue will produce this response. (status code 422)
     * or Internal Server Error issue will produce this response. (status code 500)
     */
    @ApiOperation(value = "update headcount of Conference",
            nickname = "updateHeadcountById",
            notes = "Updates headcount for existing Conference by id providing a value for headcount property.",
            response = ConferenceDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ConferenceDto.class),
            @ApiResponse(code = 404, message = "Resource not found issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "Bad Request issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error issue will produce this response.", response = ErrorResponse.class)})
    @PutMapping(
            value = "/conference/{id}",
            produces = {"application/json"}
    )
    ResponseEntity<ConferenceDto> updateHeadcountById(
            @PathVariable("id")  @ApiParam(value = "Conference id", required = true) String id,
            @RequestParam(value = "headcount", required = true) @ApiParam(value = "Value for headcount property of Conference", required = true) @Valid  @NotNull @Min(1) Integer headcount);

    /**
     * PUT /conference : update Conference
     * Updates existing Conference
     *
     * @param conferenceDto (required)
     * @return OK (status code 200)
     * or Resource not found issue will produce this response. (status code 404)
     * or Bad Request issue will produce this response. (status code 400)
     * or Unprocessable Entity issue will produce this response. (status code 422)
     * or Internal Server Error issue will produce this response. (status code 500)
     */
    @ApiOperation(value = "update Conference", nickname = "updateConference", notes = "Updates existing Conference", response = ConferenceDto.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ConferenceDto.class),
            @ApiResponse(code = 404, message = "Resource not found issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "Bad Request issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "Unprocessable Entity issue will produce this response.", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error issue will produce this response.", response = ErrorResponse.class)})
    @PutMapping(
            value = "/conference",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<ConferenceDto> updateConference(@ApiParam(value = "Conference dto", required = true) @Valid @RequestBody ConferenceDto conferenceDto);

}
