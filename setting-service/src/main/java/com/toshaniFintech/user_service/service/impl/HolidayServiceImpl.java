package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.dto.request.HolidayRequest;
import com.toshaniFintech.user_service.dto.response.HolidayResponse;
import com.toshaniFintech.user_service.entity.HolidayEntity;
import com.toshaniFintech.user_service.exception.UnprocessableEntityException;
import com.toshaniFintech.user_service.repository.HolidayRepository;
import com.toshaniFintech.user_service.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;
    @Override
    public HolidayResponse createHoliday(HolidayRequest holidayRequest) {

        if (holidayRepository.findByHolidayName(holidayRequest.getHolidayName()).isPresent()) {
            throw new UnprocessableEntityException(
                    "Holiday already exists with key: " + holidayRequest.getHolidayName()
            );
        }
        HolidayEntity entity = mapToEntity(holidayRequest);
        HolidayEntity savedEntity = holidayRepository.save(entity);
        return mapToModel(savedEntity);
    }
    @Override
    public List<HolidayResponse> getAllHolidays() {
        List<HolidayEntity> holidays = holidayRepository.findAll();
        return holidays.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    private HolidayEntity mapToEntity(HolidayRequest request) {
        HolidayEntity entity = new HolidayEntity();
        entity.setHolidayName(request.getHolidayName());
        entity.setHolidayDate(request.getHolidayDate());
        return entity;
    }

    private HolidayResponse mapToModel(HolidayEntity entity) {
        HolidayResponse response = new HolidayResponse();
        response.setHolidayName(entity.getHolidayName());
        response.setHolidayDate(entity.getHolidayDate());
        return response;
    }
}
