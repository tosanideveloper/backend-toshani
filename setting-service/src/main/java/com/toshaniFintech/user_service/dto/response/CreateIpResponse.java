package com.toshaniFintech.user_service.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateIpResponse {
    private String name;

    private String ipAddress;

    private String ipAddressOne;

    private String ipAddressTwo;

    private String ipAddressThree;

    private String ipAddressFour;

    private String ipAddresses;
}

