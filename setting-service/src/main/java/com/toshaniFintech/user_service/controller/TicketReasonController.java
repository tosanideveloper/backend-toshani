package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.TicketReasonRequestDTO;
import com.toshaniFintech.user_service.dto.response.TicketReasonResponseDTO;
import com.toshaniFintech.user_service.model.TicketReasonModel;
import com.toshaniFintech.user_service.service.TicketReasonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reason-list")
@Tag(name = "Ticket Reasons API", description = "APIs for Ticket Reasons CRUD")
public class TicketReasonController {
    @Autowired
    private TicketReasonService ticketReasonService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(
            summary = "Ticket Reason",
            description = "Create a API for ticket Reason"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Reason created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketReasonResponseDTO>> createTicketReason(@Valid @RequestBody TicketReasonRequestDTO ticketReasonRequestDTO) {
        TicketReasonModel ticketReasonModel = objectMapper.convertValue(ticketReasonRequestDTO, TicketReasonModel.class);
        TicketReasonModel updatedModel = ticketReasonService.createTicketReason( ticketReasonModel);
        TicketReasonResponseDTO responseDTO = objectMapper.convertValue(updatedModel, TicketReasonResponseDTO.class);
        return ResponseUtil.success("Ticket Reason created successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Ticket Reason",
            description = "fetch all ticket Reason"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Reason fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<TicketReasonModel>>> getTicketReasons() {
        return ResponseUtil.success("Ticket Reason fetched successfully", ticketReasonService.getAllTicketReasons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Ticket Reason",
            description = "Get ticket Reason by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Reason fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketReasonModel>> getTicketReasonByID(@PathVariable String id) {
        return ResponseUtil.success("Ticket Reason fetched successfully", ticketReasonService.getTicketReasonByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Ticket Reason",
            description = "Update ticket Reason by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Reason updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketReasonResponseDTO>> updateTicketReason(@PathVariable String id, @Valid @RequestBody TicketReasonRequestDTO ticketReasonRequestDTO) {
        TicketReasonModel ticketReasonModel = objectMapper.convertValue(ticketReasonRequestDTO, TicketReasonModel.class);
        TicketReasonModel updatedModel = ticketReasonService.updateTicketReason(id, ticketReasonModel);
        TicketReasonResponseDTO responseDTO = objectMapper.convertValue(updatedModel, TicketReasonResponseDTO.class);
        return ResponseUtil.success("Ticket Reason updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Ticket Reason",
            description = "Delete ticket Reason"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Reason deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })    public ResponseEntity<APIResponse<Object>> deleteTicketReason(@PathVariable String id) {
        ticketReasonService.deleteTicketReason(id);
        return ResponseUtil.success("Ticket Reason deleted successfully", null, HttpStatus.OK);
    }
}
