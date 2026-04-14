package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.SettlementBankModel;
import com.toshaniFintech.user_service.model.TicketReasonModel;

import java.util.List;

public interface SettlementBankService {
    List<SettlementBankModel> getAllSettlementBanks();

    SettlementBankModel createSettlementBank(SettlementBankModel settlementBankModel);

    SettlementBankModel updateSettlementBank(String id, SettlementBankModel settlementBankModel);

    void deleteSettlementBank(String id);

    SettlementBankModel getSettlementBankByID(String id);
}
