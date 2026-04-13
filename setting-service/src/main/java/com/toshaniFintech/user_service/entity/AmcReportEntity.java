package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "th_amc_report")
public class AmcReportEntity extends BaseEntity {
    @Column(name = "emi_create_date")
    private Date emiCreateDate;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "agent_detail")
    private String agentDetail;

    @Column(name = "txn_id", unique = true)
    private String txnId;

    @Column(name = "total_collection_amt")
    private BigDecimal totalCollectionAmt;

    @Column(name = "emi_amount")
    private BigDecimal emiAmount;

    @Column(name = "total_days")
    private Integer totalDays;

}
