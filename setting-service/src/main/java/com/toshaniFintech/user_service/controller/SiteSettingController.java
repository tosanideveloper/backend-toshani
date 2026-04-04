package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.dto.request.SiteSettingRequestDTO;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.SiteSettingResponseDTO;
import com.toshaniFintech.user_service.model.SiteSettingModel;
import com.toshaniFintech.user_service.service.SiteSettingService;
import com.toshaniFintech.user_service.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/site-setting")
@Tag(name = "Site Setting API", description = "APIs for Site Settings CRUD")
public class SiteSettingController {

    @Autowired
    SiteSettingService siteSettingService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/get")
    public ResponseEntity<APIResponse<List<SiteSettingModel>>> getAllSiteSetting() {
        return ResponseUtil.success("Site Settings fetched successfully", siteSettingService.getAllSiteSettings(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<SiteSettingResponseDTO>> updateSetting(@PathVariable String id, @Valid @RequestBody SiteSettingRequestDTO siteSettingRequestDTO) {
        SiteSettingModel siteSettingModel = objectMapper.convertValue(siteSettingRequestDTO, SiteSettingModel.class);
        SiteSettingModel updatedModel = siteSettingService.updateSiteSetting(id, siteSettingModel);
        SiteSettingResponseDTO responseDTO = objectMapper.convertValue(updatedModel, SiteSettingResponseDTO.class);
        return ResponseUtil.success("Site Setting updated successfully", responseDTO, HttpStatus.OK);
    }

}
