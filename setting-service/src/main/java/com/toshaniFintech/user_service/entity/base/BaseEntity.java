package com.toshaniFintech.user_service.entity.base;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 50)
    protected String id;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime lastModifiedAt;

    @Column(name ="deleted_date")
    private LocalDateTime deletedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name="is_active")
    private boolean active = true;
}