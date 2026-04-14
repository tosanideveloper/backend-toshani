package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.DsaBankRequestDTO;
import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.user_service.dto.response.DsaBankResponseDTO;
import com.toshaniFintech.user_service.dto.response.SettingResponse;
import com.toshaniFintech.user_service.service.DsaBankService;
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
@RequestMapping("/api/v1/dsa_bank")

@Tag(name = "Dsa Bank List", description = "APIs for Dsa Bank List CRUD")
public class DsaBankController {

    @Autowired
    private DsaBankService dsaBankService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @Operation(
        summary = "Dsa Bank",
        description = "This api is for Dsa Bank List"
)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Dsa Bank list created successfully",
                content = @Content(schema = @Schema(implementation = APIResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "409", description = "Data does not exists"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
})
    public ResponseEntity<APIResponse<DsaBankResponseDTO>> createDsaBanks(@Valid @RequestBody DsaBankRequestDTO dsaBankRequestDTO) {

        return ResponseUtil.success("Dca Bank list created successfully",
                dsaBankService.createDsaBankService(dsaBankRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dca Bank list fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<List<DsaBankResponseDTO>>> getAllDsaBanks() {
        return ResponseUtil.success(
                "Dca Bank list fetched successfully",
                dsaBankService.getAllDsaBanks(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dca Bank list fetched by id successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<DsaBankResponseDTO>> getDsaBankById(@PathVariable String id) {
        return ResponseUtil.success(
                "Dca Bank list fetched successfully",
                dsaBankService.getDsaBankById(id),
                HttpStatus.OK
        );
    }
    @PutMapping("/update/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dca Bank list fetched by id successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Data does not exists"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<DsaBankResponseDTO>> updateDsaBank(
            @PathVariable String id,
            @Valid @RequestBody DsaBankRequestDTO dsaBankRequestDTO) {
        return ResponseUtil.success(
                "Dca Bank list updated successfully",
                dsaBankService.updateDsaBank(id, dsaBankRequestDTO),
                HttpStatus.OK
        );
    }
}
