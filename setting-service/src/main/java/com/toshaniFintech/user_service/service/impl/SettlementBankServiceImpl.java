package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.entity.SettlementBankEntity;
import com.toshaniFintech.user_service.model.SettlementBankModel;
import com.toshaniFintech.user_service.repository.SettlementBankRepository;
import com.toshaniFintech.user_service.service.SettlementBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SettlementBankServiceImpl implements SettlementBankService {

    @Autowired
    private SettlementBankRepository repository;

    // ✅ CREATE
    @Override
    public SettlementBankModel createSettlementBank(SettlementBankModel model) {

        SettlementBankEntity entity = new SettlementBankEntity();

        entity.setId(UUID.randomUUID().toString());
        entity.setDate(model.getDate());

        entity.setAgentID(model.getAgentDetails().getAgentID());
        entity.setAgentName(model.getAgentDetails().getAgentName());

        entity.setBankName(model.getBankDetails().getBankName());
        entity.setAccountNo(model.getBankDetails().getAccountNo());
        entity.setIfscCode(model.getBankDetails().getIfscCode());

        SettlementBankEntity saved = repository.save(entity);

        return mapToModel(saved);
    }

    // ✅ GET ALL
    @Override
    public List<SettlementBankModel> getAllSettlementBanks() {
        return repository.findAll()
                .stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    // ✅ GET BY ID
    @Override
    public SettlementBankModel getSettlementBankByID(String id) {
        SettlementBankEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Settlement Bank not found with id: " + id));

        return mapToModel(entity);
    }

    // ✅ UPDATE
    @Override
    public SettlementBankModel updateSettlementBank(String id, SettlementBankModel model) {

        SettlementBankEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Settlement Bank not found with id: " + id));

        entity.setDate(model.getDate());
        entity.setAgentID(model.getAgentDetails().getAgentID());
        entity.setAgentName(model.getAgentDetails().getAgentName());
        entity.setBankName(model.getBankDetails().getBankName());
        entity.setAccountNo(model.getBankDetails().getAccountNo());
        entity.setIfscCode(model.getBankDetails().getIfscCode());

        SettlementBankEntity updated = repository.save(entity);

        return mapToModel(updated);
    }

    // ✅ DELETE (SOFT)
    @Override
    public void deleteSettlementBank(String id) {

        SettlementBankEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Settlement Bank not found with id: " + id));

        entity.setActive(false);
        entity.setDeletedAt(LocalDateTime.now());

        repository.save(entity);
    }

    // ✅ MAPPER
    private SettlementBankModel mapToModel(SettlementBankEntity entity) {

        SettlementBankModel model = new SettlementBankModel();
        model.setId(entity.getId()); // 🔥 IMPORTANT (avoid null id)
        model.setDate(entity.getDate());

        SettlementBankModel.AgentDetails agent = new SettlementBankModel.AgentDetails();
        agent.setAgentID(entity.getAgentID());
        agent.setAgentName(entity.getAgentName());

        SettlementBankModel.BankDetails bank = new SettlementBankModel.BankDetails();
        bank.setBankName(entity.getBankName());
        bank.setAccountNo(entity.getAccountNo());
        bank.setIfscCode(entity.getIfscCode());

        model.setAgentDetails(agent);
        model.setBankDetails(bank);

        return model;
    }
}