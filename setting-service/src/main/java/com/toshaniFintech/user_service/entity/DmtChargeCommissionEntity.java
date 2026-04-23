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
@Table(name = "dmt_charge_commission")
public class DmtChargeCommissionEntity extends BaseEntity {
    @Column(name = "min_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "max_amount", nullable = false)
    private BigDecimal maxAmount;

    @Column(name = "comm_type", nullable = false)
    private String commType;

    @Column(name = "comm", nullable = false)
    private BigDecimal comm;

    public DmtChargeCommissionEntity(){
    }
    public DmtChargeCommissionEntity(Long id,BigDecimal minAmount,BigDecimal maxAmount,
                                     String commType,BigDecimal comm){
      this.minAmount = minAmount;
      this.maxAmount = maxAmount;
      this.commType = commType;
      this.comm = comm;
    }

}
