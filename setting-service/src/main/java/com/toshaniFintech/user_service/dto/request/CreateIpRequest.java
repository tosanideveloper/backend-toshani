package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateIpRequest {
    @NotBlank(message = "Name should not be empty")
    private String name;
    @NotBlank(message = "Ip should not be empty")
    private String ipAddress;
    @NotBlank(message = "Ip should not be empty")
    private String ipAddressOne;
    @NotBlank(message = "Ip should not be empty")
    private String ipAddressTwo;
    @NotBlank(message = "Ip should not be empty")
    private String ipAddressThree;
    @NotBlank(message = "Ip should not be empty")
    private String ipAddressFour;
    @NotBlank(message = "Ip should not be empty")
    private String ipAddresses;
}
