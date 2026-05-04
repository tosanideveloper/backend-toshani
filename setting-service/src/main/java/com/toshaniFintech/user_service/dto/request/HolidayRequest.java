package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class HolidayRequest {
    @NotBlank(message = "holidayName must not be blank")
    @Size(max = 50, message = "holidayName must not exceed 50 characters")
    private String holidayName;
    @NotNull(message = "holidayDate is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate holidayDate;
}

