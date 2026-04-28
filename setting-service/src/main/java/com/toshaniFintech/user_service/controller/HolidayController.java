package com.toshaniFintech.user_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.HolidayRequest;
import com.toshaniFintech.user_service.dto.response.HolidayResponse;
import com.toshaniFintech.user_service.service.HolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/holiday")
@Tag(name = "Holiday API", description = "APIs for Holiday CRUD")
public class HolidayController {
    
    @Autowired
    private HolidayService holidayService;
    @PostMapping("/create")
    @Operation(
            summary = "Holiday List",
            description = "To Create Holiday List"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Holiday already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<HolidayResponse>> createHoliday(
            @Valid @RequestBody HolidayRequest request) {
        return ResponseUtil.success(
                "Holiday created successfully",
                holidayService.createHoliday(request),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/all")
    @Operation(
            summary = "Holiday List",
            description = "To Fetch Holiday List"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetch Holiday successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Holiday already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<HolidayResponse>>> getAllHolidays() {
        return ResponseUtil.success(
                "Holiday fetched successfully",
                holidayService.getAllHolidays(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Get Holiday By ID",
            description = "To Fetch Holiday By ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Holiday already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<HolidayResponse>> getHolidayById(@PathVariable Long id) {
        return ResponseUtil.success(
                "Holiday fetched successfully",
                holidayService.getHolidayById(String.valueOf(id)),
                HttpStatus.OK
        );
    }
    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update Holiday List",
            description = "To Update an Existing Holiday List"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday Updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Holiday already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<HolidayResponse>> updateHoliday(
            @PathVariable String id,
            @Valid @RequestBody HolidayRequest holidayRequest) {
        return ResponseUtil.success(
                "Holiday updated successfully",
                holidayService.updateHoliday(id, holidayRequest),
                HttpStatus.OK
        );
    }
}