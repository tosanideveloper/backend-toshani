package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class PartnerIpConfigurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pipc_uuid")
    private String pipcuuid;

    @Column(name = "partner_uuid")
    private String partneruuid;

    @Column(name = "ip_uuid")
    private String ipuuid;

    @Column(name = "menu_uuid")
    private String menuuuid;

    @Column(name = "status")
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPipcuuid() { return pipcuuid; }
    public void setPipcuuid(String pipcuuid) { this.pipcuuid = pipcuuid; }

    public String getPartneruuid() { return partneruuid; }
    public void setPartneruuid(String partneruuid) { this.partneruuid = partneruuid; }

    public String getIpuuid() { return ipuuid; }
    public void setIpuuid(String ipuuid) { this.ipuuid = ipuuid; }

    public String getMenuuuid() { return menuuuid; }
    public void setMenuuuid(String menuuuid) { this.menuuuid = menuuuid; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
