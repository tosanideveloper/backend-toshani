package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_paytm_pos_charge")
public class PaytmPosChargeEntity extends BaseEntity {

    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "payment_mode")
    private String paymentMode;
    @Column(name = "charge_type")// UPI / NB
    private String chargeType;
    @Column(name = "charge")// Percent / Fixed
    private Double charge;

    public PaytmPosChargeEntity(Double minAmount, Double maxAmount, String paymentMode, String chargeType, Double charge) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.paymentMode = paymentMode;
        this.chargeType = chargeType;
        this.charge = charge;
    }

    public PaytmPosChargeEntity() {

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

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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

