package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="th_aeps2_merchant_report")
public class Aeps2MerchantReportEntity extends BaseEntity {
    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "userName")
    private String userName;

    @Column(name = "merchant_name")
    private String merchantName;

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getPartnerDetails() {
        return partnerDetails;
    }

    public void setPartnerDetails(String partnerDetails) {
        this.partnerDetails = partnerDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = userName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String bankName) {
        this.merchantName = merchantName;
    }


}
