package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_ticket_details")
@Getter
@Setter
public class TicketDetailsEntity extends BaseEntity {
    @Column(name = "complaint_on")
    private String complaintOn;

    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "partner_details")
    private String partnerDetails;

    @Column(name = "transaction_date")
    private String transactionDate;

    @Column(name = "transaction_status")
    private String transactionStatus;
}
