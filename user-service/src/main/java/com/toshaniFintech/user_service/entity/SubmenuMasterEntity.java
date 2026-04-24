package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class SubmenuMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "submenu_uuid")
    private String submenuuuid;

    @Column(name = "menu_uuid")
    private String menuuuid;

    @Column(name = "submenu_name")
    private String submenuname;

    @Column(name = "end_points")
    private String endpoints;

    @Column(name = "status")
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubmenuuuid() { return submenuuuid; }
    public void setSubmenuuuid(String submenuuuid) { this.submenuuuid = submenuuuid; }

    public String getMenuuuid() { return menuuuid; }
    public void setMenuuuid(String menuuuid) { this.menuuuid = menuuuid; }

    public String getSubmenuname() { return submenuname; }
    public void setSubmenuname(String submenuname) { this.submenuname = submenuname; }

    public String getEndpoints() { return endpoints; }
    public void setEndpoints(String endpoints) { this.endpoints = endpoints; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
