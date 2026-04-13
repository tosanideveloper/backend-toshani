package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.ManageSettlementModel;

import java.util.List;

public interface ManageSettlementService {
    List<ManageSettlementModel> getAllSettlementTime();

    ManageSettlementModel getSettlementTimeById(String id);

    ManageSettlementModel updateSettlementTime(String id, ManageSettlementModel manageSettlementModel);
}
