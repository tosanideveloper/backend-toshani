package com.toshaniFintech.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.dto.response.APIResponse;
import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.common.utils.AppConstant;
import com.toshaniFintech.common.utils.ResponseUtil;
import com.toshaniFintech.user_service.dto.response.ActivityReportResponse;
import com.toshaniFintech.user_service.service.ActivityReportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/activity-report")
@Tag(name = "Activity Report API", description = "APIs for Activity Report CRUD")
public class ActivityReportController {
    @Autowired
    private ActivityReportService activityReportService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/all")
    public ResponseEntity<APIResponse<PaginatedResponse<ActivityReportResponse>>> getAllActivityReport(
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

        PaginatedResponse<ActivityReportResponse> response =
                activityReportService.getAllActivityReport(pageRequest);

        return ResponseUtil.success(
                "Activity Report fetched successfully",
                response,
                HttpStatus.OK
        );
    }
}
