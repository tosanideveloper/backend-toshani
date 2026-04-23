package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_matm_commission")

public class MatmCommissionEntity extends BaseEntity {

    private String id;
    private Double minAmount;
    private Double maxAmount;
    private String commType;
    private Double comm;

    public MatmCommissionEntity(Double minAmount, Double maxAmount, String commType, Double comm) {

        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.commType = commType;
        this.comm = comm;
    }
    public MatmCommissionEntity() {

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

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }
}
