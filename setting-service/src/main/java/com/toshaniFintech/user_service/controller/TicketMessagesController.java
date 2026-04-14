package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.TicketMessageRequestDTO;
import com.toshaniFintech.user_service.dto.response.TicketMessagesResponseDTO;
import com.toshaniFintech.user_service.model.TicketMessagesModel;
import com.toshaniFintech.user_service.service.TicketMessagesService;
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
@RequestMapping("/api/v1/ticket-messages")
@Tag(name = "Ticket Messages API", description = "APIs for Ticket messages CRUD")
public class TicketMessagesController {

    @Autowired
    private TicketMessagesService ticketMessagesService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(
            summary = "Ticket Messages",
            description = "Create a API for ticket message"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket message created successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketMessagesResponseDTO>> createTicketMessage(@Valid @RequestBody TicketMessageRequestDTO ticketMessageRequestDTO) {
        TicketMessagesModel ticketMessagesModel = objectMapper.convertValue(ticketMessageRequestDTO, TicketMessagesModel.class);
        TicketMessagesModel updatedModel = ticketMessagesService.createTicketMessages( ticketMessagesModel);
        TicketMessagesResponseDTO responseDTO = objectMapper.convertValue(updatedModel, TicketMessagesResponseDTO.class);
        return ResponseUtil.success("Ticket message created successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Ticket Messages",
            description = "fetch all ticket messages"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket message fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    public ResponseEntity<APIResponse<List<TicketMessagesModel>>> getTicketMessages() {
        return ResponseUtil.success("Ticket message fetched successfully", ticketMessagesService.getTicketMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Ticket Messages",
            description = "Get ticket message by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket message fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketMessagesModel>> getTicketMessageByID(@PathVariable String id) {
        return ResponseUtil.success("Ticket message fetched successfully", ticketMessagesService.getTicketMessageByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Ticket Messages",
            description = "Update ticket messages by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket message updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketMessagesResponseDTO>> updateTicketMessage(@PathVariable String id, @Valid @RequestBody TicketMessageRequestDTO ticketMessageRequestDTO) {
        TicketMessagesModel ticketMessagesModel = objectMapper.convertValue(ticketMessageRequestDTO, TicketMessagesModel.class);
        TicketMessagesModel updatedModel = ticketMessagesService.updateTicketMessage(id, ticketMessagesModel);
        TicketMessagesResponseDTO responseDTO = objectMapper.convertValue(updatedModel, TicketMessagesResponseDTO.class);
        return ResponseUtil.success("Ticket message updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Ticket Messages",
            description = "Delete ticket message"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket message deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })    public ResponseEntity<APIResponse<Object>> deleteTicketMessage(@PathVariable String id) {
        ticketMessagesService.deleteTicketMessage(id);
        return ResponseUtil.success("Ticket message deleted successfully", null, HttpStatus.OK);
    }

}
