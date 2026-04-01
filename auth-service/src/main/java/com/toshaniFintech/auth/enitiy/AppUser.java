package com.toshaniFintech.auth.enitiy;

import com.toshaniFintech.auth.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "th_app_user")
public class AppUser extends BaseEntity{
    private String username;
    private String password;
    private String role;
}
