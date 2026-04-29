package com.toshaniFintech.settlement.service;

import com.toshaniFintech.common.dto.response.PaginatedResponse;
import com.toshaniFintech.settlement.dto.request.CreateSettlementRequest;
import com.toshaniFintech.settlement.dto.request.SettlementReportRequest;
import com.toshaniFintech.settlement.dto.request.UpdateSettlementRequest;
import com.toshaniFintech.settlement.dto.response.SettlementResponse;

import java.util.List;

public interface SettlementService {

    SettlementResponse createSettlement(CreateSettlementRequest request);

    PaginatedResponse<SettlementResponse> getAllSettlements(int pageNo, int pageSize, String sortBy, String orderType);

    SettlementResponse getSettlementById(String id);

    SettlementResponse updateSettlement(String id, UpdateSettlementRequest request);

    List<SettlementResponse> getSettlementsByUser(String userUuid);

    PaginatedResponse<SettlementResponse> getSettlementReport(SettlementReportRequest request);
}