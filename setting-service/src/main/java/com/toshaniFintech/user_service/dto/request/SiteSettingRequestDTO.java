package com.toshaniFintech.user_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SiteSettingRequestDTO {
    @NotBlank(message = "id must not be blank")
    @Size(max = 8, message = "id must not exceed 10 characters")
    private Long id;
    @NotBlank(message = "address must not be blank")
    @Size(max = 10, message = "address must not exceed 10 characters")
    private String address;
    @NotBlank(message = "city must not be blank")
    @Size(max = 10, message = "city must not exceed 10 characters")
    private String city;
    @NotBlank(message = "pinCode must not be blank")
    @Size(max = 6, message = "pinCode must not exceed 6 characters")
    private String pinCode;
    @NotBlank(message = "phone must not be blank")
    @Size(max = 10, message = "phone must not exceed 10 characters")
    private String phone;
    @NotBlank(message = "email must not be blank")
    @Size(max = 10, message = "email must not exceed 10 characters")
    private String email;
    @NotBlank(message = "state must not be blank")
    @Size(max = 10, message = "state must not exceed 10 characters")
    private String state;
    @NotBlank(message = "country must not be blank")
    @Size(max = 10, message = "country must not exceed 10 characters")
    private String country;
    @NotBlank(message = "metaTitle must not be blank")
    @Size(max = 10, message = "metaTitle must not exceed 10 characters")
    private String metaTitle;
    @NotBlank(message = "metaDesc must not be blank")
    @Size(max = 10, message = "metaDesc must not exceed 10 characters")
    private String metaDesc;
    @NotBlank(message = "metaKey must not be blank")
    @Size(max = 10, message = "metaKey must not exceed 10 characters")
    private String metaKey;
}
