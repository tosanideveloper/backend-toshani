package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_site_settings")
@Getter
@Setter
public class SiteSettingEntity extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "pinCode")
    private String pinCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_desc")
    private String metaDesc;

    @Column(name = "meta_key")
    private String metaKey;

}
