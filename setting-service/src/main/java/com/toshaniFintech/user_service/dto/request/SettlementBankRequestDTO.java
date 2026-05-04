package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SettlementBankRequestDTO {

    @NotBlank(message = "date must not be blank")
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "date must be in format yyyy-MM-dd"
    )
    private String date;

    @NotNull(message = "agentDetails must not be null")
    @Valid
    private AgentDetails agentDetails;

    @NotNull(message = "bankDetails must not be null")
    @Valid
    private BankDetails bankDetails;

    // 🔹 AGENT DETAILS
    @Data
    public static class AgentDetails {

        @NotBlank(message = "agentID must not be blank")
        @Size(max = 50, message = "agentID must not exceed 50 characters")
        private String agentID;

        @NotBlank(message = "agentName must not be blank")
        @Size(max = 100, message = "agentName must not exceed 100 characters")
        private String agentName;
    }

    // 🔹 BANK DETAILS
    @Data
    public static class BankDetails {

        @NotBlank(message = "bankName must not be blank")
        @Size(max = 100, message = "bankName must not exceed 100 characters")
        private String bankName;

        @NotBlank(message = "accountNo must not be blank")
        @Pattern(
                regexp = "^[0-9]{9,18}$",
                message = "accountNo must be 9 to 18 digits"
        )
        private String accountNo;

        @NotBlank(message = "ifscCode must not be blank")
        @Pattern(
                regexp = "^[A-Z]{4}0[A-Z0-9]{6}$",
                message = "Invalid IFSC Code format (e.g., SBIN0001234)"
        )
        private String ifscCode;
    }
}