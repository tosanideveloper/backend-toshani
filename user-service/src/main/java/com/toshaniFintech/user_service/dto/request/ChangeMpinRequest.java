package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ChangeMpinRequest {

    @NotBlank
    @Pattern(regexp = "^[0-9]{4,6}$", message = "Old MPIN must be 4 to 6 digits")
    private String oldMpin;

    @NotBlank
    @Pattern(regexp = "^[0-9]{4,6}$", message = "New MPIN must be 4 to 6 digits")
    private String newMpin;

    @NotBlank
    private String confirmMpin;
}
