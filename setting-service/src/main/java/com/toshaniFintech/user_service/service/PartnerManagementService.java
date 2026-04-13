package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.PartnerManagementModel;

import java.util.List;

public interface PartnerManagementService {
    List<PartnerManagementModel> getPartnerManagement();

    PartnerManagementModel createPartnerManagement(PartnerManagementModel partnerManagementModel);

    PartnerManagementModel updatePartnerManagement(String id, PartnerManagementModel partnerManagementModel);

    void deletePartnerManagement(String id);

    PartnerManagementModel getPartnerManagementByID(String id);
}
