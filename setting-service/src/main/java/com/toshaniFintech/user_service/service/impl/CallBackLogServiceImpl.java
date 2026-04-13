package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.CallBackLogEntity;
import com.toshaniFintech.user_service.model.CallBackLogModel;
import com.toshaniFintech.user_service.repository.CallBackLogRepository;
import com.toshaniFintech.user_service.service.CallBackLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallBackLogServiceImpl implements CallBackLogService {
    @Autowired
    private CallBackLogRepository callBackRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<CallBackLogModel> getCallBackLog() {
        List<CallBackLogEntity> callBackEntityList = callBackRepository.findAll();
        return callBackEntityList.stream().map(callBackLog -> objectMapper.convertValue(callBackEntityList, CallBackLogModel.class)).toList();
    }
}
