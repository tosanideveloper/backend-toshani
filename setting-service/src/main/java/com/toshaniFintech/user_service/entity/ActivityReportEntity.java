package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_activity_report")
public class ActivityReportEntity extends BaseEntity {
    @Column(name = "txn_date")
    private String txnDate;

    @Column(name = "api_user_detail")
    private String apiUserDetail;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "function_name")
    private String functionName;

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }


    public String getApiUserDetail() {
        return apiUserDetail;
    }

    public void setApiUserDetail(String apiUserDetail) {
        this.apiUserDetail = apiUserDetail;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }



}
