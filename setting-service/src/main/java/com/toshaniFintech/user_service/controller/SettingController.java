package com.toshaniFintech.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.toshaniFintech.user_service.dto.request.SettingRequest;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.SettingResponse;
import com.toshaniFintech.common.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.toshaniFintech.user_service.service.SettingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/setting")
@Tag(name = "Setting API", description = "APIs for Settings CRUD")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<SettingResponse>> createSetting(
            @Valid @RequestBody SettingRequest request) {
        return ResponseUtil.success(
                "Setting created successfully",
                settingService.createSetting(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<SettingResponse>>> getAllSetting() {
        return ResponseUtil.success(
                "Settings fetched successfully",
                settingService.getAllSettings(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<SettingResponse>> getSettingById(@PathVariable String id) {
        return ResponseUtil.success(
                "Setting fetched successfully",
                settingService.getSettingById(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<SettingResponse>> updateSetting(
            @PathVariable String id,
            @Valid @RequestBody SettingRequest settingRequest) {
        return ResponseUtil.success(
                "Setting updated successfully",
                settingService.updateSetting(id, settingRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Object>> deleteSetting(@PathVariable String id) {
        settingService.deleteSetting(id);
        return ResponseUtil.success(
                "Setting deleted successfully",
                null,
                HttpStatus.OK
        );
    }
}