package com.toshaniFintech.user_service.model;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HolidayListModel {
    private String id;
    private String  holidayName;
    private String date;
}
