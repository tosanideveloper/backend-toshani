package com.toshaniFintech.settlement.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Defines the T+N settlement cycle for each product.
 * settlement_day=0 means same-day (realtime); 1 means next-day (T+1); 2 means T+2.
 * AEPS=1, POS=2, UPI=0, MATM=not yet defined as per sheet data.
 */
@Getter
@Setter
@Entity
@Table(name = "th_product_master")
public class ProductMaster extends BaseEntity {

    @Column(name = "product_uuid", nullable = false, unique = true)
    private String productUuid;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    // Number of days after transaction_date when the amount is eligible for cashout
    @Column(name = "settlement_day", nullable = false)
    private Integer settlementDay;
}