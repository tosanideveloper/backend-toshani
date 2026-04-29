package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_aeps3_aadhaar_pay_commission")
public class Aeps3AadharPayCommissionEntity extends BaseEntity {
    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "charge_type")
    private String chargeType;
    @Column(name = "charge")
    private Double charge;
    @Column(name = "rrn")
    private String rrn;

    public Aeps3AadharPayCommissionEntity(Double minAmount, Double maxAmount, String chargeType, Double charge, String rrn) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chargeType = chargeType;
        this.charge = charge;
        this.rrn = rrn;
    }

    public Aeps3AadharPayCommissionEntity() {
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}
