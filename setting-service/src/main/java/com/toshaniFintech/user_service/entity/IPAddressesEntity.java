package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "th_ip_addresses")
public class IPAddressesEntity extends BaseEntity {
    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "ip_address_one")
    private String ipAddressOne;

    @Column(name = "ip_address_two")
    private String ipAddressTwo;

    @Column(name = "ip_address_three")
    private String ipAddressThree;

    @Column(name = "ip_address_four")
    private String ipAddressFour;

    @Column(name = "ip_addresses")
    private String ipAddresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddressOne() {
        return ipAddressOne;
    }

    public void setIpAddressOne(String ipAddressOne) {
        this.ipAddressOne = ipAddressOne;
    }

    public String getIpAddressTwo() {
        return ipAddressTwo;
    }

    public void setIpAddressTwo(String ipAddressTwo) {
        this.ipAddressTwo = ipAddressTwo;
    }

    public String getIpAddressThree() {
        return ipAddressThree;
    }

    public void setIpAddressThree(String ipAddressThree) {
        this.ipAddressThree = ipAddressThree;
    }

    public String getIpAddressFour() {
        return ipAddressFour;
    }

    public void setIpAddressFour(String ipAddressFour) {
        this.ipAddressFour = ipAddressFour;
    }

    public String getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(String ipAddresses) {
        this.ipAddresses = ipAddresses;
    }
}

