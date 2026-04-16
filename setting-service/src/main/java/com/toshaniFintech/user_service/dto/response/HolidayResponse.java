package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HolidayResponse {
    private String Id;
    private String holidayName;
    private LocalDate holidayDate;
}
