package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.HolidayRequest;
import com.toshaniFintech.user_service.dto.response.HolidayResponse;
import com.toshaniFintech.user_service.model.HolidaysModel;
import com.toshaniFintech.user_service.model.TicketMessagesModel;

import java.util.List;

public interface HolidayService {
    List<HolidaysModel> getAllHolidays();
    HolidaysModel createHoliday(HolidaysModel holidaysModel);
    HolidaysModel updateHoliday(String id, HolidaysModel holidaysModel);
    HolidaysModel getHolidayById(String id);
}
