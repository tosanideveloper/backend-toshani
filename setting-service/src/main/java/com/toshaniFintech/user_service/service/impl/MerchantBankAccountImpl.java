package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.MerchantBankAccEntity;
import com.toshaniFintech.user_service.model.MerchantBankAccModel;
import com.toshaniFintech.user_service.repository.MerchantBankAccRepository;
import com.toshaniFintech.user_service.service.MerchantBankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantBankAccountImpl implements MerchantBankAccountService {


    @Autowired
    MerchantBankAccRepository merchantBankAccRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<MerchantBankAccModel> getMerchantBankAcc() {
        List<MerchantBankAccEntity> merchantBankAccEntityList = merchantBankAccRepository.findAll();
        return merchantBankAccEntityList.stream().map(merchantBankAccEntities -> objectMapper.convertValue(merchantBankAccEntities, MerchantBankAccModel.class)).toList();
    }
}
