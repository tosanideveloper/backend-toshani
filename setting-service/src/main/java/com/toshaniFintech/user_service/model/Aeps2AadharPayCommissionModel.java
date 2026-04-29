package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class Aeps2AadharPayCommissionModel {
    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double comm;
    private String rrn;
}
