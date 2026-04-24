package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_merchant_bank_accounts")
@Getter
@Setter
public class MerchantBankAccEntity extends BaseEntity {
    @Column(name = "date")
    private String date;
    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "api_partner_name")
    private String apiPartnerName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "acc_number")
    private String accNo;

    @Column(name = "acc_holder_name")
    private String accHolderName;

}
