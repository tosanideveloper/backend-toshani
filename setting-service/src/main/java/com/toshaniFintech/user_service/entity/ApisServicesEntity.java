package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TH_API_SEFRVICES")
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
