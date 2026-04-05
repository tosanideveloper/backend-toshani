package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.HolidayListEntity;
import com.toshaniFintech.user_service.model.HolidayListModel;
import com.toshaniFintech.user_service.repository.HolidayListRepository;
import com.toshaniFintech.user_service.service.HolidayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayListServiceImpl implements HolidayListService {

    @Autowired
    private HolidayListRepository holidayListRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<HolidayListModel> getHolidayList() {
        List<HolidayListEntity> all = holidayListRepository.findAll();
        return all.stream().map(entity -> objectMapper.convertValue(entity, HolidayListModel.class)).toList();
    }
}
