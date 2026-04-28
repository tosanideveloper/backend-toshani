package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateIpRequest {

    @NotBlank(message = "name must not be blank")
    @Size(max = 100, message = "name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "ipAddress must not be blank")
    @Size(max = 500, message = "ipAddress string must not exceed 500 characters")
    private String ipAddress;

    @NotBlank(message = "ipAddress-one must not be blank")
    @Size(max = 500, message = "ipAddress-one string must not exceed 500 characters")
    private String ipAddressOne;

    @Size(max = 500, message = "ipAddress-two string must not exceed 500 characters")
    private String ipAddressTwo;

    @Size(max = 500, message = "ipAddress-three string must not exceed 500 characters")
    private String ipAddressThree;

    private String ipAddressFour;

    private String ipAddresses;
}
