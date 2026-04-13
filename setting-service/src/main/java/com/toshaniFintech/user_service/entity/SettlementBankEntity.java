package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_settlemt_banks")
@Getter
@Setter
public class SettlementBankEntity extends BaseEntity {
    @Column(name = "date")
    private String date;

    @Column(name = "agent_id")
    private String agentID;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "ifsc_code")
    private String ifscCode;

}
