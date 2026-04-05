package com.toshaniFintech.user_service.controller;

import com.toshaniFintech.user_service.dto.request.IpAddressRequest;
import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.dto.response.IpAddressResponse;
import com.toshaniFintech.user_service.service.IpAddressService;
import com.toshaniFintech.user_service.util.ResponseUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ip-address")
@Tag(name = "IP Address API", description = "APIs for IP Address CRUD")
public class IpAddressController {

    @Autowired
    private IpAddressService ipAddressService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<IpAddressResponse>> createIpAddress(
            @Valid @RequestBody IpAddressRequest request) {
        
        return ResponseUtil.success(
            "IP Address created successfully",
            ipAddressService.createIpAddress(request),
            HttpStatus.CREATED
        );
    }
}