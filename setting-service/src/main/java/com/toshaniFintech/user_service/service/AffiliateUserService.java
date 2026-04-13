package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.model.AffiliateUserModel;
import com.toshaniFintech.user_service.model.ApiPartnerServiceModel;
import com.toshaniFintech.user_service.model.CallBackLogModel;

import java.util.List;

public interface AffiliateUserService {
    List<AffiliateUserModel> getAffiliateUSer();
    AffiliateUserModel createAffiliateUser(AffiliateUserModel affiliateUserModel);
    void deleteUser(String id);


}
