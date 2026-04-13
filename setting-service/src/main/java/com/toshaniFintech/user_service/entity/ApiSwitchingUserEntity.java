package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_api_switch_user")
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
