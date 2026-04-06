package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TH_SETTLEMENT_TIME")
@Getter
@Setter
public class ManageSettlementEntity extends BaseEntity {
    @Column(name = "day")
    private String day;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private Boolean endTime;
}
