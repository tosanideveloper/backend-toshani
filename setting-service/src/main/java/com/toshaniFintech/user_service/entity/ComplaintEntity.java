package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import com.toshaniFintech.user_service.dto.request.ComplaintRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="th_complaints")
public class ComplaintEntity extends BaseEntity {
    @Column(name = "complaint_id", nullable = false, unique = true)
    private String complaintId;
    @Column(name = "complaint_on")
    private LocalDateTime complaintOn;
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

    public ComplaintEntity() {
    }

    public ComplaintEntity(String complaintId, LocalDateTime complaintOn, String agentDetails, String requestUrl,
                           String request, String response, String attachment, String status) {
        this.complaintId = complaintId;
        this.complaintOn = complaintOn;
        this.agentDetails = agentDetails;
        this.requestUrl = requestUrl;
        this.request = request;
        this.response = response;
        this.attachment = attachment;
        this.status = status;
    }

    public void setMessages(List <String>messages) {
    }
    public org.hibernate.mapping.List getMessages() {
        return null;
    }

    public void setResponse(ComplaintRequest complaintRequest, Object getResponse) {
    }
    public String getComplaintsId() {
        return "";
    }
}
