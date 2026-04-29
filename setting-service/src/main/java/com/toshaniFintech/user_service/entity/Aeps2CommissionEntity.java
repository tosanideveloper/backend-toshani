package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_aeps2_commission")

public class Aeps2CommissionEntity extends BaseEntity {

    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "comm_type")
    private String commType;
    @Column(name = "commission")
    private Double commission;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "rrn")
    private String rrn;

    public Aeps2CommissionEntity(Double minAmount, Double maxAmount, String commType, Double commission, String transactionType, String rrn) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.commType = commType;
        this.commission = commission;
        this.transactionType = transactionType;
        this.rrn = rrn;
    }

    public Aeps2CommissionEntity() {
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}