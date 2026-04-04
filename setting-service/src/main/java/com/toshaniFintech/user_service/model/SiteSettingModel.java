package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class SiteSettingModel {
    private Long id;
    private String address;
    private String city;
    private String pinCode;
    private String phone;
    private String email;
    private String state;
    private String country;
    private String metaTitle;
    private String metaDesc;
    private String metaKey;
}
