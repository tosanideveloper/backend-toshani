package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateIpRequest {
    @NotBlank(message = "Name should not be empty")
    private String name;

    @NotBlank(message = "Ip should not be empty")
    private String ipAddress;

    private String ipAddressOne;

    private String ipAddressTwo;

    private String ipAddressThree;

    private String ipAddressFour;

    private String ipAddresses;
}
