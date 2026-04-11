package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MpinSetRequest {

    @NotBlank(message = "MPIN is required")
    @Pattern(regexp = "^[0-9]{4,6}$", message = "MPIN must be 4 to 6 digits")
    private String mpin;

    @NotBlank(message = "Confirm MPIN is required")
    private String confirmMpin;
}
