package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.response.AEPS3ReportResponse;
import com.toshaniFintech.user_service.service.AEPS3ReportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aeps3-report")
@Tag(name = "AEPS3 Report API", description = "APIs for Manage AEPS3 Report CRUD")
public class AEPS3ReportController {
    @Autowired
    private AEPS3ReportService aeps3ReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    public ResponseEntity<APIResponse<List<AEPS3ReportResponse>>> getAllAEPS3Report(
            @RequestParam(name = AppConstant.PAGE_NUMBER_PROPERTY_NAME,
                    defaultValue = AppConstant.PAGE_NUMBER_DEFAULT_VALUE,
                    required = false) int pageNo,

            @RequestParam(name = AppConstant.PAGE_SIZE_PROPERTY_NAME,
                    defaultValue = AppConstant.PAGE_SIZE_DEFAULT_VALUE,
                    required = false) int pageSize,

            @RequestParam(name = AppConstant.SORT_BY_PROPERTY_NAME,
                    defaultValue = AppConstant.SORT_BY_DEFAULT_VALUE,
                    required = false) String sortBy,

            @RequestParam(name = AppConstant.ORDER_TYPE_PROPERTY_NAME,
                    defaultValue = AppConstant.ORDER_TYPE_DEFAULT_VALUE,
                    required = false) String orderType,

            @RequestParam(name = AppConstant.SEARCH_PROPERTY_NAME,
                    required = false) String searchString
    ) {

        PageRequest pageRequest;

        if (AppConstant.ORDER_TYPE_DEFAULT_VALUE.equalsIgnoreCase(orderType)) {
            pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        List<AEPS3ReportResponse> response =
                aeps3ReportService.getAllAEPS3Report(pageRequest);

        return ResponseUtil.success(
                "AEPS3 Report fetched successfully",
                response,
                HttpStatus.OK
        );
    }
}
