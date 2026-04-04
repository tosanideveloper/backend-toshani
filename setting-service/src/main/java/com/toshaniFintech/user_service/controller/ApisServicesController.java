package com.toshaniFintech.user_service.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.ApisServicesRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.ApisServicesResponseDTO;
import com.toshaniFintech.user_service.dto.response.SiteSettingResponseDTO;
import com.toshaniFintech.user_service.model.ApisServiceModel;
import com.toshaniFintech.user_service.model.SiteSettingModel;
import com.toshaniFintech.user_service.service.ApisService;
import com.toshaniFintech.user_service.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/api_service")
@Tag(name = "API Services", description = "APIs Services for CRUD")
public class ApisServicesController {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private ApisService apisService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<ApisServicesResponseDTO>> createApis(@Valid @RequestBody ApisServicesRequestDTO apisServicesRequestDto) {
        ApisServiceModel apisServiceModel = objectMapper.convertValue(apisServicesRequestDto, ApisServiceModel.class);
        ApisServiceModel updatedModel = apisService.createApisService( apisServiceModel);
        ApisServicesResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ApisServicesResponseDTO.class);
        return ResponseUtil.success("Site Setting updated successfully", responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<APIResponse<List<ApisServiceModel>>> getApisServices() {
        return ResponseUtil.success("Apis Services fetched successfully", apisService.getApisService(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<ApisServicesResponseDTO>> updateSetting(@PathVariable String id, @Valid @RequestBody ApisServicesRequestDTO apisServicesRequestDTO) {
        ApisServiceModel apisServiceModel = objectMapper.convertValue(apisServicesRequestDTO, ApisServiceModel.class);
        ApisServiceModel updatedModel = apisService.updateApisServices(id, apisServiceModel);
        ApisServicesResponseDTO responseDTO = objectMapper.convertValue(updatedModel, ApisServicesResponseDTO.class);
        return ResponseUtil.success("Apis service updated successfully", responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Object>> deleteApisService(@PathVariable String id) {
        apisService.deleteApisService(id);
        return ResponseUtil.success("Setting deleted successfully", null, HttpStatus.OK);
    }
}
