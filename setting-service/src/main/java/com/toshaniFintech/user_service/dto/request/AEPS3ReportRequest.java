package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AEPS3ReportRequest {
    @NotBlank(message = "fromDate must not be blank")
    @Size(max = 10, message = "fromDate must not exceed 10 characters")
    private String fromDate;

    @NotBlank(message = "toDate must not be blank")
    @Size(max = 10, message = "toDate must not exceed 10 characters")
    private String toDate;

    @Size(max = 100, message = "partnerName must not exceed 100 characters")
    private String partnerName;

    @Size(max = 50, message = "partnerId must not exceed 50 characters")
    private String partnerId;

    @Size(max = 100, message = "transactionId must not exceed 100 characters")
    private String transactionId;

    @Size(max = 100, message = "orderId must not exceed 100 characters")
    private String orderId;

    @Size(max = 50, message = "merchantCode must not exceed 50 characters")
    private String merchantCode;

    @Size(max = 100, message = "apiTransactionId must not exceed 100 characters")
    private String apiTransactionId;

    @Size(max = 20, message = "aadhaarNo must not exceed 20 characters")
    private String aadhaarNo;

    @Size(max = 50, message = "transactionType must not exceed 50 characters")
    private String transactionType;

    @Size(max = 50, message = "bankName must not exceed 50 characters")
    private String bankName;


    @Size(max = 20, message = "amount must not exceed 20 characters")
    private String amount;

    @Size(max = 50, message = "utr must not exceed 50 characters")
    private String utr;

    @Size(max = 20, message = "commission must not exceed 20 characters")
    private String commission;

    @Size(max = 20, message = "tds must not exceed 20 characters")
    private String tds;

    @Size(max = 20, message = "charges must not exceed 20 characters")
    private String charges;

    @Size(max = 20, message = "gst must not exceed 20 characters")
    private String gst;
}
