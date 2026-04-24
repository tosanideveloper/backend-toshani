package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class DmtLite1ReportRequestDTO {

    private List<String> transactionId;
    private List<String> orderId;
    private List<String> accountNumber;
    private List<String> ifsc;
    private List<String> utr;
    private List<String> type;
    private List<String> status;
    private List<String> apiName;

    @NotBlank(message = "startDate is required")
    private String startDate;

    @NotBlank(message = "endDate is required")
    private String endDate;

    private int pageNo;
    private int pageSize;

    private String sortBy;
    private String orderBy;

    private String search;
    private String searchByField;
}