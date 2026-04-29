package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_aeps3_commission")
public class Aeps3CommissionEntity extends BaseEntity {
    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "commission_type")
    private String commissionType;
    @Column(name = "commission")
    private Double commission;
    @Column(name = "rrn")
    private String rrn;

    public Aeps3CommissionEntity(Double minAmount, Double maxAmount, String transactionType,String commissionType, Double commission, String rrn) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.transactionType = transactionType;
        this.commissionType = commissionType;
        this.commission = commission;
        this.rrn = rrn;
    }

    public Aeps3CommissionEntity() {
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
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
}
