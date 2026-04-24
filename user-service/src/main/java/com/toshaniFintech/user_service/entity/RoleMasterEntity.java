package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class RoleMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_uuid")
    private String roleuuid;

    @Column(name = "role_name")
    private String rolename;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoleuuid() { return roleuuid; }
    public void setRoleuuid(String roleuuid) { this.roleuuid = roleuuid; }

    public String getRolename() { return rolename; }
    public void setRolename(String rolename) { this.rolename = rolename; }
}
