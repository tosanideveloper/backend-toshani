package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class RolePrivilegeDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rpd_uuid")
    private String rpduuid;

    @Column(name = "privilage_uuid")
    private String privilageuuid;

    @Column(name = "submenu_uuid")
    private String submenuuuid;

    @Column(name = "menu_uuid")
    private String menuuuid;

    @Column(name = "read_permission")
    private String readpermission;

    @Column(name = "write_permission")
    private String writepermission;

    @Column(name = "status")
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRpduuid() { return rpduuid; }
    public void setRpduuid(String rpduuid) { this.rpduuid = rpduuid; }

    public String getPrivilageuuid() { return privilageuuid; }
    public void setPrivilageuuid(String privilageuuid) { this.privilageuuid = privilageuuid; }

    public String getSubmenuuuid() { return submenuuuid; }
    public void setSubmenuuuid(String submenuuuid) { this.submenuuuid = submenuuuid; }

    public String getMenuuuid() { return menuuuid; }
    public void setMenuuuid(String menuuuid) { this.menuuuid = menuuuid; }

    public String getReadpermission() { return readpermission; }
    public void setReadpermission(String readpermission) { this.readpermission = readpermission; }

    public String getWritepermission() { return writepermission; }
    public void setWritepermission(String writepermission) { this.writepermission = writepermission; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
