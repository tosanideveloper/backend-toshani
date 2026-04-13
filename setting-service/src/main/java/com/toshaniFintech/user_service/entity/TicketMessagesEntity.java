package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_ticket_messages")
@Getter
@Setter
public class TicketMessagesEntity extends BaseEntity {
    @Column(name = "category")
    private String category;

    @Column(name = "message")
    private String message;

    @Column(name="status")
    private String status;

}
