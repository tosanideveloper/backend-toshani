package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TH_HOLIDAYS")
@Getter
@Setter

public class HolidayListEntity extends BaseEntity {

    @Column (name = "holiday_name")
    private String holidayName;

    @Column (name = "holiday_date")
    private String holidayDate;
}
