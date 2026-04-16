package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Aeps1ReportRequestDTO {
    private List<String> orderId;
    private List<String> txnId;
    private List<String> txnType;
    private List<String> status;

    @NotBlank(message = "startDate is required")
    private String startDate;

    @NotBlank(message = "endDate is required")
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;


}
