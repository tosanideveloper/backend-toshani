package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.request.Aeps2AadharPayCommissionGetAll;
import com.toshaniFintech.user_service.dto.request.Aeps2AadharPayCommissionRequestDTO;
import com.toshaniFintech.user_service.dto.response.Aeps2AadharPayCommissionResponseDTO;
import com.toshaniFintech.user_service.model.Aeps2AadharPayCommissionModel;
import com.toshaniFintech.user_service.service.Aeps2AadharPayCommissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aeps2-aadhaar-pay-commission")

@Tag(name = "Aeps2 Aadhaar Pay Commission API", description = "APIs for Aeps2 Aadhaar Pay Commission CRUD")

public class Aeps2AadharPayCommissionController {

    @Autowired
    private Aeps2AadharPayCommissionService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Aeps2AadharPayCommissionResponseDTO>> createAeps2AadharPay(
            @Valid @RequestBody Aeps2AadharPayCommissionRequestDTO requestDTO) {

        Aeps2AadharPayCommissionModel model =
                objectMapper.convertValue(requestDTO, Aeps2AadharPayCommissionModel.class);

        Aeps2AadharPayCommissionModel saved =
                service.createAeps2AadharPay(model);

        Aeps2AadharPayCommissionResponseDTO response =
                objectMapper.convertValue(saved, Aeps2AadharPayCommissionResponseDTO.class);

        return ResponseUtil.success(
                "Aeps2 Aadhaar Pay Commission created successfully",
                response,
                HttpStatus.OK
        );
    }

    @PostMapping("/all")
    public ResponseEntity<PaginatedResponse<Aeps2AadharPayCommissionResponseDTO>> getAllAeps2AadharPay(
            @Valid @RequestBody Aeps2AadharPayCommissionGetAll aeps2AadharPayCommissionGetAll) {

        return new ResponseEntity<>(
                service.getAllAeps2AadharPay(aeps2AadharPayCommissionGetAll),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Aeps2AadharPayCommissionResponseDTO>> getByIdAeps2AadharPay(
            @PathVariable String id) {

        Aeps2AadharPayCommissionResponseDTO response =
                service.getByIdAeps2AadharPay(id);

        return ResponseUtil.success(
                "Aeps2 Aadhaar Pay Commission fetched successfully",
                response,
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<Aeps2AadharPayCommissionResponseDTO>> updateAeps2AadharPay(
            @PathVariable String id,
            @Valid @RequestBody Aeps2AadharPayCommissionRequestDTO requestDTO) {

        Aeps2AadharPayCommissionModel model =
                objectMapper.convertValue(requestDTO, Aeps2AadharPayCommissionModel.class);

        Aeps2AadharPayCommissionResponseDTO response =
                service.updateAeps2AadharPay(id, model);

        return ResponseUtil.success(
                "Aeps2 Aadhaar Pay Commission updated successfully",
                response,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<String>> deleteAeps2AadharPay(
            @PathVariable String id) {

        service.deleteAeps2AadharPay(id);

        return ResponseUtil.success(
                "Aeps2 Aadhaar Pay Commission deleted successfully",
                "Deleted",
                HttpStatus.OK
        );
    }
}