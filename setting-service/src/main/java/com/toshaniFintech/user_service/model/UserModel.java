package com.toshaniFintech.user_service.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
}
