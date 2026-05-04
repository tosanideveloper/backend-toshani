package com.toshaniFintech.user_service.entity;


import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "th_settlement_report")
@Getter
@Setter
@ToString
public class SettlementReportEntity extends BaseEntity {

    @Column(name = "txn_date")
    private Date txnDate;

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "txn_id")
    private String txnID;

    @Column(name = "order_id")
    private String orderID;

    @Column(name = "api_txn_id")
    private String apiTxnID;

    @Column(name = "acc_no")
    private String accNo;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "utr")
    private String utr;

    @Column(name = "txn_type")
    private String txnType;
    @Column(name = "txn_status")
    private String txnStatus;
    @Column(name = "rrn")
    private String rrn;

    @Column(name = "amount")
    private String amount;

    @Column(name = "charges")
    private String charges;

    @Column(name = "gst_no")
    private String gstNo;

    @Column(name = "api_name")
    private String apiName;

    @Column(name = "request", columnDefinition = "TEXT")
    private String request;

    @Column(name = "response", columnDefinition = "TEXT")
    private String response;

    @Column(name = "callback", columnDefinition = "TEXT")
    private String callback;
}