package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_aeps1_commission")

public class Aeps1CommissionEntity extends BaseEntity {

    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "comm_type")
    private String commType;
    @Column(name = "commission")
    private Double commission;
    @Column(name = "rrn")
    private String rrn;

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

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public Aeps1CommissionEntity(Double minAmount, Double maxAmount, String commType, Double commission, String rrn) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.commType = commType;
        this.commission = commission;
        this.rrn = rrn;

    }
}
