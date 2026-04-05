package com.toshaniFintech.user_service.controller;


import com.toshaniFintech.user_service.dto.response.APIResponse;
import com.toshaniFintech.user_service.model.HolidayListModel;
import com.toshaniFintech.user_service.model.UserModel;
import com.toshaniFintech.user_service.service.HolidayListService;
import com.toshaniFintech.user_service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/holiday")
public class HolidayListController {
    @Autowired
    HolidayListService holidayListService;

    @GetMapping(value = "/get")
    public ResponseEntity<APIResponse<List<HolidayListModel>>> getHolidayList(){
        return ResponseUtil.success(
                "Holiday List fetched successfully",
                holidayListService.getHolidayList(),
                HttpStatus.OK
        );
    }
}
