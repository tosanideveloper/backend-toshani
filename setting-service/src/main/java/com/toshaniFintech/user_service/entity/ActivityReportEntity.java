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
@Table(name = "th_activity_report")
public class ActivityReportEntity extends BaseEntity {
    @Column(name = "api_user_detail", length = 150)
    private String apiUserDetail;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "function_name", length = 255)
    private String functionName;

    public ActivityReportEntity() {
        this.apiUserDetail = apiUserDetail;
        this.updatedBy = updatedBy;
        this.functionName = functionName;
    }
}
