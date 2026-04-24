package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class HolidayRequest {
    @NotBlank(message = "Holiday Name must not be blank")
    @Size(max = 50, message = "Holiday Name must not exceed 50 characters")
    private String holidayName;
    @NotBlank(message = "Holiday Date is required")
    private String holidayDate;
    @NotBlank(message = "Holiday type is required")
    private String holidayType;
}

