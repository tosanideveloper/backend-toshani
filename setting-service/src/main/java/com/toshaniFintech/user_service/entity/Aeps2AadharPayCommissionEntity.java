package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_aeps2_aadhaar_pay_commission")
public class Aeps2AadharPayCommissionEntity extends BaseEntity {
    @Column(name = "min_amount")
    private Double minAmount;
    @Column(name = "max_amount")
    private Double maxAmount;
    @Column(name = "comm_type")
    private String commType;
    @Column(name = "comm")
    private Double comm;
    @Column(name = "rrn")
    private String rrn;

    public Aeps2AadharPayCommissionEntity(Double minAmount, Double maxAmount, String commType, Double comm, String rrn) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.commType = commType;
        this.comm = comm;
        this.rrn = rrn;
    }

    public Aeps2AadharPayCommissionEntity() {
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

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}
