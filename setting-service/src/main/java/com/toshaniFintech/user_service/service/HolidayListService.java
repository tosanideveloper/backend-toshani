package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.HolidayListModel;
import com.toshaniFintech.user_service.model.IPAddressModel;

import java.util.List;

public interface HolidayListService {
    List<HolidayListModel> getHolidayList();
}
