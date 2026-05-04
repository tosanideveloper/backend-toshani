package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class Aeps3ReportRequest {
    private List<String> orderId;
    private List<String> txnId;
    private List<String> txnType;
    private List<String> status;

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

    private String partnerName;
    private String partnerId;
    private String merchantCode;
    private String aadhaarNo;
    private String bankName;
    private String amount;
    private String utr;
    private String commission;
    private String tds;
    private String charges;
    private String gst;
}
