package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.TicketDetailsRequestDTO;
import com.toshaniFintech.user_service.dto.response.TicketDetailsResponseDTO;
import com.toshaniFintech.user_service.model.TicketDetailsModel;
import com.toshaniFintech.user_service.service.TicketDetailsService;
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
@RequestMapping("/api/v1/ticket-service")
@Tag(name = "Ticket Service API", description = "APIs for Ticket Service CRUD")
public class TicketDetailsController {

    @Autowired
    private TicketDetailsService ticketDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/all")
    @Operation(
            summary = "Ticket Details API",
            description = "This api is to fetch ticket Details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Details fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<TicketDetailsModel>>> getAllTickets() {
        return ResponseUtil.success("Ticket Details fetched successfully", ticketDetailsService.getAllTickets(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Ticket Details API",
            description = "This api is to fetch ticket Details by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Details fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketDetailsModel>> getTicketByID(@PathVariable String id) {
        return ResponseUtil.success("Ticket Details fetched successfully", ticketDetailsService.getTicketByID(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Ticket Details API",
            description = "This api is to update ticket Details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Details updated successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<TicketDetailsResponseDTO>> updateTicketDetails(@PathVariable String id, @Valid @RequestBody TicketDetailsRequestDTO ticketDetailsRequestDTO) {
        TicketDetailsModel ticketDetailsModel = objectMapper.convertValue(ticketDetailsRequestDTO, TicketDetailsModel.class);
        TicketDetailsModel updatedModel = ticketDetailsService.updateTicketDetails(id, ticketDetailsModel);
        TicketDetailsResponseDTO responseDTO = objectMapper.convertValue(updatedModel, TicketDetailsResponseDTO.class);
        return ResponseUtil.success("Ticket Details updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Ticket Details API",
            description = "This api is to delete ticket Details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Details deleted successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "User already exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })    public ResponseEntity<APIResponse<Object>> deleteTickets(@PathVariable String id) {
        ticketDetailsService.deleteTickets(id);
        return ResponseUtil.success("Ticket Details deleted successfully", null, HttpStatus.OK);
    }

}
