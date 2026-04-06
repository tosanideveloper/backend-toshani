package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.HolidayRequest;
import com.toshaniFintech.user_service.dto.response.HolidayResponse;

import java.util.List;

public interface HolidayService {
    HolidayResponse createHoliday(HolidayRequest holidayRequest);
    List<HolidayResponse> getAllHolidays();
}
