package com.toshaniFintech.user_service.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toshaniFintech.common.exception.model.NotFoundException;
import com.toshaniFintech.user_service.entity.ReconciliationReportEntity;
import com.toshaniFintech.user_service.model.ReconciliationReportModel;
import com.toshaniFintech.user_service.repository.ReconciliationReportRepository;
import com.toshaniFintech.user_service.service.ReconciliationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ReconciliationReportImpl implements ReconciliationReportService {

    @Autowired
    private ReconciliationReportRepository reconciliationReportRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ReconciliationReportModel createReconciliationReport(ReconciliationReportModel reconciliationReportModel) {
        ReconciliationReportEntity reconciliationReportEntity = reconciliationReportRepository.findById(String.valueOf(AbstractPersistable_.id)).orElseThrow(() -> new NotFoundException("Messages not found with id: " + id));
        reconciliationReportEntity.setTxnDate(String.valueOf(reconciliationReportModel.getTxnDate()));
        reconciliationReportEntity.setDebitWalletOpening(reconciliationReportModel.getDebitWalletOpening());
        reconciliationReportEntity.setDebitWalletClosing(reconciliationReportModel.getDebitWalletClosing());
        reconciliationReportEntity.setCreditTotal(reconciliationReportModel.getCreditTotal());
        reconciliationReportEntity.setDebitTotal(reconciliationReportModel.getDebitTotal());
        ReconciliationReportEntity saved = reconciliationReportRepository.save(reconciliationReportEntity);

        return objectMapper.convertValue(saved, ReconciliationReportModel.class);
    }

}
