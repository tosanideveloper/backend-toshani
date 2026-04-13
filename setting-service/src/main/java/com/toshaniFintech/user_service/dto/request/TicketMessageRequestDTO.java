package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TicketMessageRequestDTO {
    @NotBlank(message = "Category must not be blank")
    private String category;

    @NotBlank(message = "Message must not be blank")
    private String message;

    @NotBlank(message = "Status must not be blank")
    private String status;
}
