package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "th_remittance_charge_commission")
public class RemittanceChargeCommissionEntity extends BaseEntity {
    @Column(name = "min_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "max_amount", nullable = false)
    private BigDecimal maxAmount;

    @Column(name = "charge_type", nullable = false)
    private String chargeType;

    @Column(name = "charge", nullable = false)
    private BigDecimal charge;

    public RemittanceChargeCommissionEntity() {
    }

    public RemittanceChargeCommissionEntity(Long Id,String minAmount, String maxAmount, String chargeType, String charge) {
        this.minAmount = new BigDecimal(minAmount);
        this.maxAmount = new BigDecimal(maxAmount);
        this.chargeType = chargeType;
        this.charge = new BigDecimal(charge);
    }
}
