package com.toshaniFintech.user_service.dto.response;

import com.toshaniFintech.user_service.model.SettlementBankModel;
import lombok.Data;

import java.util.List;

@Data
public class SettlementBankResponseDTO {
    private String id;
    private List<SettlementBankModel> settlementBankModels;
}
