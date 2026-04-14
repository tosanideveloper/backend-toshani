package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "th_holiday")
public class HolidayEntity extends BaseEntity {
    @Column(name = "holiday_name", nullable = false)
    private String holidayName;
    @Column(name = "holiday_date", nullable = false)
    private LocalDate holidayDate;
    public HolidayEntity(){

    }
    public HolidayEntity(String holidayName, LocalDate holidayDate){
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;

    }
}
