package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "th_complaints")
public class ComplaintEntity extends BaseEntity {

    @Column(name = "complaint_id", nullable = false, unique = true)
    private String complaintId;

    @Column(name = "complaint_on")
    private LocalDate complaintOn;

    @Column(name = "agent_details")
    private String agentDetails;

    @Column(name = "request_url")
    private String requestUrl;

    @Column(name = "request_payload", columnDefinition = "TEXT")
    private String request;

    @Column(name = "response_payload", columnDefinition = "TEXT")
    private String response;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "status")
    private String status;

    // ✅ IMPORTANT FIX
    @ElementCollection
    @CollectionTable(name = "th_complaint_messages", joinColumns = @JoinColumn(name = "complaint_id"))
    @Column(name = "message")
    private List<String> messages;
}