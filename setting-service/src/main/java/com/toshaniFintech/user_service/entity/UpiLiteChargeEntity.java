package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "th_upilite_charge")
public class UpiLiteChargeEntity extends BaseEntity {

    @Column(name = "min_amount")
    private Double minAmount;

    @Column(name = "max_amount")
    private Double maxAmount;

    @Column(name = "charge_type")
    private String chargeType;

    @Column(name = "charge")
    private Double charge;

    // getters & setters

    public UpiLiteChargeEntity(Double minAmount, Double maxAmount, String chargeType, Double charge) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.chargeType = chargeType;
        this.charge = charge;
    }

    public UpiLiteChargeEntity() {

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
}