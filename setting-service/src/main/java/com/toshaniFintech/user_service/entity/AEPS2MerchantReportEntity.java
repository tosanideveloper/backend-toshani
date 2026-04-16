package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="th_aeps2_merchant_report")
public class AEPS2MerchantReportEntity extends BaseEntity {
    @Column(name = "txn_date")
    private LocalDate date;

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "username")
    private String username;

    @Column(name = "merchant_name")
    private String merchantName;

    public AEPS2MerchantReportEntity() {
    }

    public AEPS2MerchantReportEntity(Long Id,
                                     LocalDate date,
                                     String partnerDetails,
                                     String username,
                                     String merchantName) {

        this.date = date;
        this.partnerDetails = partnerDetails;
        this.username = username;
        this.merchantName = merchantName;
    }

}
