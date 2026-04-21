package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "th_payout_charge_commission")
public class PayoutChargeCommissionEntity extends BaseEntity {
    @Column(name = "min_amount", nullable = false)
    private Double minAmount;

    @Column(name = "max_amount", nullable = false)
    private Double maxAmount;

    @Column(name = "txn_type", nullable = false)
    private String txnType;

    @Column(name = "charge_type", nullable = false)
    private String chargeType; // Fixed / Percent

    @Column(name = "charge", nullable = false)
    private Double charge;

    public PayoutChargeCommissionEntity(){
    }
    public PayoutChargeCommissionEntity(Long Id,Double minAmount,Double maxAmount,
                                        String txnType,String chargeType,Double charge){
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.txnType = txnType;
        this.chargeType = chargeType;
        this.charge = charge;
    }
}
