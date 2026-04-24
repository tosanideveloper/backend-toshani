package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class RolePrivilegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "privilage_uuid")
    private String privilageuuid;

    @Column(name = "privilage_name")
    private String privilagename;

    @Column(name = "status")
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPrivilageuuid() { return privilageuuid; }
    public void setPrivilageuuid(String privilageuuid) { this.privilageuuid = privilageuuid; }

    public String getPrivilagename() { return privilagename; }
    public void setPrivilagename(String privilagename) { this.privilagename = privilagename; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
