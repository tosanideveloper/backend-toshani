package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "th_ip_addresses")
public class IpAddressEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ip_address", nullable = false)
    private String ipaddress;

    @Column(name = "ip_address_one")
    private String ipaddressOne;

    @Column(name = "ip_address_two")
    private String ipaddressTwo;

    @Column(name = "ip_address_three")
    private String ipaddressThree;

    @Column(name = "ip_address_four")
    private String ipaddressFour;

    @Column(name = "ip_addresses", length = 1000)
    private String ipaddresses;

    public IpAddressEntity() {
    }

    public IpAddressEntity(Long id, String name, String ipaddress, String ipaddressOne, 
                          String ipaddressTwo, String ipaddressThree, String ipaddressFour, 
                          String ipaddresses) {
        this.name = name;
        this.ipaddress = ipaddress;
        this.ipaddressOne = ipaddressOne;
        this.ipaddressTwo = ipaddressTwo;
        this.ipaddressThree = ipaddressThree;
        this.ipaddressFour = ipaddressFour;
        this.ipaddresses = ipaddresses;
    }
}