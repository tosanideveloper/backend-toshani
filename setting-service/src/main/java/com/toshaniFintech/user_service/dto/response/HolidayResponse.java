package com.toshaniFintech.user_service.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HolidayResponse {
    private String id;
    private String holidayName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate holidayDate;

    private String holidayType;
}
