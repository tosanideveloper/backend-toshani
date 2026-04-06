package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class IpAddressRequest {

    @NotBlank(message = "name must not be blank")
    @Size(max = 100, message = "name must not exceed 100 characters")
    private String name;
    @NotBlank(message = "ipAddress must not be blank")
    @Size(max = 500, message = "ipAddress list/string must not exceed 500 characters")
    private String ipAddress;
    @NotBlank(message = "ipAddress-one must not be blank")
    @Size(max = 500, message = "ipAddress-one list/string must not exceed 500 characters")
    private String ipAddressOne;
    @NotBlank(message = "ipAddress-two must not be blank")
    @Size(max = 500, message = "ipAddress-two list/string must not exceed 500 characters")
    private String ipAddressTwo;
    @NotBlank(message = "ipAddress-three must not be blank")
    @Size(max = 500, message = "ipAddress-three list/string must not exceed 500 characters")
    private String ipAddressThree;
    @NotBlank(message = "ipAddress-four must not be blank")
    @Size(max = 500, message = "ipAddress-four list/string must not exceed 500 characters")
    private String ipAddressFour;
    @NotBlank(message = "ipAddresses must not be blank")
    @Size(max = 500, message = "ipAddresses list/string must not exceed 500 characters")
    private String ipAddresses;
}