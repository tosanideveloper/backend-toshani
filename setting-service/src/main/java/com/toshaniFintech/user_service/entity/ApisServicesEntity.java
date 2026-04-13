package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_api_services")
@Getter
@Setter
public class ApisServicesEntity extends BaseEntity {

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "api_name")
    private String apiName;

    @Column(name = "status")
    private String status;

}
