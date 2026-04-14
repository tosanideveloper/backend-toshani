package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TicketReasonRequestDTO {
    private String id;
    @NotBlank(message = "Category must not be blank")
    private String category;

    @NotBlank(message = "Reason must not be blank")
    private String reason;

    @NotBlank(message = "Status must not be blank")
    private String status;

    @NotBlank(message = "createdDate must not be blank")
    private String createdDate;
}
