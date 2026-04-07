package com.toshaniFintech.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"createdAt", "updatedAt", "employee"})

@Entity
@Table(name = "th_user", uniqueConstraints = {
        @UniqueConstraint(name = "UK_email", columnNames = {"email"})
})
public class Users extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1445348085860121253L;

    @NotNull
    @Column(name = "email")
    @Pattern(regexp = "^[^@ ]+@[^@ ]+\\.[^@ ]+$", message = "Enter valid email id")
    private String email;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @Size(max = 255)
    private String password;

    @Pattern(regexp = "\\d{10}", message = "Enter valid 10 digit mobile number")
    @Column(name = "mobile_number", length = 200, nullable = true)
    private String mobile;

    @Column(name = "is_mobile_verified")
    private boolean mobileVerified = false;

    @Column(name = "is_email_verified")
    private boolean emailVerified = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "th_user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    private String allowedDevices;

}
