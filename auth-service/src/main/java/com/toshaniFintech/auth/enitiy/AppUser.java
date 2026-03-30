package com.toshaniFintech.auth.enitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AppUser {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role;
}
