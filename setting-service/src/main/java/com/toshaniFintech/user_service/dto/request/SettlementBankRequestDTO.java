package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class SettlementBankRequestDTO {
    private String date;
    private AgentDetails agentDetails;
    private BankDetails bankDetails;

    @Data
    public static class AgentDetails {
        private String agentID;
        private String agentName;
    }
    @Data
    public static class BankDetails {
        private String bankName;
        private String accountNo;
        private String ifscCode;
    }
}
