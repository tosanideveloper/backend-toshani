package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class MenuMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_uuid")
    private String menuuuid;

    @Column(name = "menu_name")
    private String menuname;

    @Column(name = "super_admin_privilage")
    private String superadminprivilage;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMenuuuid() { return menuuuid; }
    public void setMenuuuid(String menuuuid) { this.menuuuid = menuuuid; }

    public String getMenuname() { return menuname; }
    public void setMenuname(String menuname) { this.menuname = menuname; }

    public String getSuperadminprivilage() { return superadminprivilage; }
    public void setSuperadminprivilage(String superadminprivilage) { this.superadminprivilage = superadminprivilage; }
}
