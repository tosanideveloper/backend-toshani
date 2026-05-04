package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.FingPayOnboardEntity;
import com.toshaniFintech.user_service.model.FingPayOnboardModel;
import com.toshaniFintech.user_service.repository.FingPayOnboardRepository;
import com.toshaniFintech.user_service.service.FingPayOnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FingPayOnboardImpl implements FingPayOnboardService {

    @Autowired
    private FingPayOnboardRepository fingPayOnboardRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<FingPayOnboardModel> getFingPayOnboardList() {
        List<FingPayOnboardEntity> fingPayOnboardEntityList = fingPayOnboardRepository.findAll();
        return fingPayOnboardEntityList.stream().map(fingPayOnboardEntity ->
                objectMapper.convertValue(fingPayOnboardEntityList, FingPayOnboardModel.class)).toList();
    }
}
