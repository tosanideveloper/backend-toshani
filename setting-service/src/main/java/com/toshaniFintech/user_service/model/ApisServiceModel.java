package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class ApisServiceModel {
    private Long id;
    private String serviceName;
    private String apiName;
    private Boolean status;
}
