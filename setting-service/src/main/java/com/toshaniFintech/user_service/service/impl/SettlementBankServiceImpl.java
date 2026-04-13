package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.user_service.entity.SettlementBankEntity;
import com.toshaniFintech.user_service.exception.NotFoundException;
import com.toshaniFintech.user_service.model.SettlementBankModel;
import com.toshaniFintech.user_service.repository.SettlementBankRepository;
import com.toshaniFintech.user_service.service.SettlementBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SettlementBankServiceImpl implements SettlementBankService {
    @Autowired
    private SettlementBankRepository settlementBankRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<SettlementBankModel> getAllSettlementBanks() {
        List<SettlementBankEntity> settlementBankEntityList = settlementBankRepository.findAll();
        return settlementBankEntityList.stream().map(settlementBanks -> objectMapper.convertValue(settlementBanks, SettlementBankModel.class)).toList();
    }

    @Override
    public SettlementBankModel createSettlementBank(SettlementBankModel settlementBankModel) {
        SettlementBankEntity settlementBankEntity = objectMapper.convertValue(settlementBankModel, SettlementBankEntity.class);
        SettlementBankEntity saved = settlementBankRepository.save(settlementBankEntity);
        return objectMapper.convertValue(saved, SettlementBankModel.class);
    }

    @Override
    public SettlementBankModel updateSettlementBank(String id, SettlementBankModel settlementBankModel) {
        settlementBankRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket Reason not found with id: " + id));
        SettlementBankEntity settlementBankEntity = objectMapper.convertValue(settlementBankModel, SettlementBankEntity.class);
        SettlementBankEntity saved = settlementBankRepository.save(settlementBankEntity);
        return objectMapper.convertValue(saved, SettlementBankModel.class);
    }

    @Override
    public void deleteSettlementBank(String id) {
        SettlementBankEntity existingEntity = settlementBankRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket Details not found with id: " + id));
        existingEntity.setActive(false);
        existingEntity.setDeletedAt(LocalDateTime.now());
        settlementBankRepository.save(existingEntity);

    }

    @Override
    public SettlementBankModel getSettlementBankByID(String id) {
        SettlementBankEntity entity = settlementBankRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket Details not found with id: " + id));
        return mapToModel(entity);
    }

    private SettlementBankModel mapToModel(SettlementBankEntity entity) {
        SettlementBankModel settlementBankModel = new SettlementBankModel();
        settlementBankModel.setDate(entity.getDate());
        SettlementBankModel.AgentDetails agentDetails = new SettlementBankModel.AgentDetails();

        agentDetails.setAgentID(entity.getAgentID());
        agentDetails.setAgentName(entity.getAgentName());

        SettlementBankModel.BankDetails bankDetails = new SettlementBankModel.BankDetails();

        bankDetails.setBankName(entity.getBankName());
        bankDetails.setAccountNo(entity.getAccountNo());
        bankDetails.setIfscCode(entity.getIfscCode());
        return objectMapper.convertValue(entity, SettlementBankModel.class);
    }
}
