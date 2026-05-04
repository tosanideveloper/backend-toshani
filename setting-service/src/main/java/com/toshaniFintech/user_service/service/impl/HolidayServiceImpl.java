package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.common.exception.model.UnprocessableEntityException;
import com.toshaniFintech.user_service.dto.request.HolidayRequest;
import com.toshaniFintech.user_service.dto.response.HolidayResponse;
import com.toshaniFintech.user_service.dto.response.TicketMessagesResponseDTO;
import com.toshaniFintech.user_service.entity.HolidayEntity;
import com.toshaniFintech.user_service.entity.TicketMessagesEntity;
import com.toshaniFintech.user_service.model.HolidaysModel;
import com.toshaniFintech.user_service.model.TicketMessagesModel;
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
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<HolidaysModel> getAllHolidays() {
        List<HolidayEntity> holidayEntityList = holidayRepository.findAll();
        return holidayEntityList.stream().map(holidayEntity -> objectMapper.convertValue(holidayEntity, HolidaysModel.class)).toList();
    }

    @Override
    public HolidaysModel createHoliday(HolidaysModel holidaysModel) {
        HolidayEntity holidayEntity = objectMapper.convertValue(holidaysModel, HolidayEntity.class);
        HolidayEntity saved = holidayRepository.save(holidayEntity);
        return objectMapper.convertValue(saved, HolidaysModel.class);

    }

    @Override
    public HolidaysModel updateHoliday(String id, HolidaysModel holidaysModel) {
        holidayRepository.findById(id).orElseThrow(() -> new RuntimeException("Holi not found with id: " + id));
        HolidayEntity holidayEntity = objectMapper.convertValue(holidaysModel, HolidayEntity.class);
        HolidayEntity saved = holidayRepository.save(holidayEntity);
        return objectMapper.convertValue(saved, HolidaysModel.class);

    }

    @Override
    public HolidaysModel getHolidayById(String id) {
        HolidayEntity entity = holidayRepository.findById(id).orElseThrow(() -> new NotFoundException("Holiday not found with id: " + id));
        return mapToModel(entity);
    }
    private HolidaysModel mapToModel(HolidayEntity entity) {
        HolidayResponse response = new HolidayResponse();
        response.setHolidayDate(entity.getHolidayDate());
        response.setHolidayName(entity.getHolidayName());

        return objectMapper.convertValue(entity, HolidaysModel.class);
    }

}
