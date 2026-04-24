package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_upicollect_report")
public class UpiCollectReportEntity extends BaseEntity {

    @Column(name = "date")
    private String date;

    @Column(name = "api_user_detail")
    private String apiUserDetail;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "api_name")
    private String apiName;

    @Column(name = "request_data", columnDefinition = "TEXT")
    private String request;

    @Column(name = "response_data", columnDefinition = "TEXT")
    private String response;

    // getters & setters
}