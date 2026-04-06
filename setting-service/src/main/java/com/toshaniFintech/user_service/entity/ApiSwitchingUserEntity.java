package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TH_API_SWITCH_USER")
@Getter
@Setter
public class ApiSwitchingUserEntity extends BaseEntity {

    @Column(name = "switch_category_code")
    private String switchCategoryCode;

    @Column(name = "switch_category_name")
    private String switchCategoryName;

    @Column(name = "switch_ip")
    private String switchIP;

}
