package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_amc_report")
public class AmcReportEntity extends BaseEntity {
    @Column(name = "emi_create_date")
    private String emiCreateDate;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "agent_detail")
    private String agentDetail;

    @Column(name = "emi_collection_txn_id")
    private String emiCollectionTxnId;

    @Column(name = "total_collection_amt")
    private String totalCollectionAmt;

    @Column(name = "emi_amount")
    private String emiAmount;

    @Column(name = "total_days")
    private Integer totalDays;

    public String getEmiCreateDate() {
        return emiCreateDate;
    }

    public void setEmiCreateDate(String emiCreateDate) {
        this.emiCreateDate = emiCreateDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAgentDetail() {
        return agentDetail;
    }

    public void setAgentDetail(String agentDetail) {
        this.agentDetail = agentDetail;
    }

    public String getEmiCollectionTxnId() {
        return emiCollectionTxnId;
    }

    public void setEmiCollectionTxnId(String txnId) {
        this.emiCollectionTxnId = emiCollectionTxnId;
    }

    public String getTotalCollectionAmt() {
        return totalCollectionAmt;
    }

    public void setTotalCollectionAmt(String totalCollectionAmt) {
        this.totalCollectionAmt = totalCollectionAmt;
    }

    public String getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(String emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

}
