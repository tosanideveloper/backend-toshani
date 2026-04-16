package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps1ReportRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps1ReportResponseDTO;
import com.toshaniFintech.user_service.model.Aeps1ReportModel;
import com.toshaniFintech.user_service.service.Aeps1ReportService;
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
@RequestMapping("api/v1/aeps1-report")
@Tag(name = "Aeps1 Report API", description = "APIs for Aeps1 Report CRUD")
public class Aeps1ReportController {

    @Autowired
    private Aeps1ReportService aeps1ReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/get")
    @Operation(summary = "Aeps1 Report", description = "Get Aeps1 Report with pagination and advanced filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aeps1 Report fetched successfully",
                    content = @Content(schema = @Schema(implementation = APIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<APIResponse<PaginatedResponse<Aeps1ReportResponseDTO>>> createAepsReport(
            @Valid @RequestBody Aeps1ReportRequestDTO aeps1ReportRequestDTO) {

        Aeps1ReportModel requestModel =
                objectMapper.convertValue(aeps1ReportRequestDTO, Aeps1ReportModel.class);

        PaginatedResponse<Aeps1ReportModel> serviceResponse =
                aeps1ReportService.createAepsReport(requestModel);

        List<Aeps1ReportResponseDTO> responseDtoList = serviceResponse.getContent().stream().map(model -> {
            Aeps1ReportResponseDTO dto = new Aeps1ReportResponseDTO();
            dto.setId(model.getId());
            dto.setTxnDate(model.getTxnDate());
            dto.setTxnID(model.getTxnID());
            dto.setOrderID(model.getOrderID());
            dto.setBankName(model.getBankName());
            dto.setAadhaarNo(model.getAadhaarNo());
            dto.setAmount(model.getAmount());
            dto.setRrn(model.getRrn());
            dto.setTxnStatus(model.getTxnStatus());
            return dto;
        }).toList();

        PaginatedResponse<Aeps1ReportResponseDTO> finalResponse = new PaginatedResponse<>();
        finalResponse.setContent(responseDtoList);
        finalResponse.setPageNumber(serviceResponse.getPageNumber());
        finalResponse.setPageSize(serviceResponse.getPageSize());
        finalResponse.setTotalElements(serviceResponse.getTotalElements());
        finalResponse.setTotalPages(serviceResponse.getTotalPages());
        finalResponse.setNumberOfElements(serviceResponse.getNumberOfElements());

        return ResponseUtil.success("Aeps1 Report fetched successfully", finalResponse, HttpStatus.OK);
    }
}