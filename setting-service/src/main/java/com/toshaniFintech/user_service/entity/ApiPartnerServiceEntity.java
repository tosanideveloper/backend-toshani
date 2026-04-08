package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_api_Partner_Services")
@Getter
@Setter
public class ApiPartnerServiceEntity extends BaseEntity {

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "date")
    private String date;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;
}
