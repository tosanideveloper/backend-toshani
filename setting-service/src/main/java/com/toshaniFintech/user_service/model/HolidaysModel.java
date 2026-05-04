package com.toshaniFintech.user_service.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HolidaysModel {
    private String id;
    private String holidayName;
    private String holidayDate;
    private String holidayType;
}
