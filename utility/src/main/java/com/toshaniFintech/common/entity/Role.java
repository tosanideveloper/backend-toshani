package com.toshaniFintech.common.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_roles")
public class Role extends BaseEntity {

    @Column(name = "name", columnDefinition = "CHAR(32)", unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}