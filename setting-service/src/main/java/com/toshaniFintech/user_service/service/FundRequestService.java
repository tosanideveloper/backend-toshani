package com.toshaniFintech.user_service.service;

import com.toshaniFintech.user_service.dto.request.FundRequestRequest;
import com.toshaniFintech.user_service.dto.response.FundRequestResponse;

import java.util.List;

public interface FundRequestService {
    List<FundRequestResponse> getAllFundRequests();
    FundRequestResponse updateFundRequest(String id, FundRequestRequest fundRequestModel);
}
