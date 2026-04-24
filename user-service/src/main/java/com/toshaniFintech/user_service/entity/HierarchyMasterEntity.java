package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class HierarchyMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hirarchy_uuid")
    private String hirarchyuuid;

    @Column(name = "hirarchy_level")
    private String hirarchylevel;

    @Column(name = "client_uuid")
    private String clientuuid;

    @Column(name = "partner_uuid")
    private String partneruuid;

    @Column(name = "channel_uuid")
    private String channeluuid;

    @Column(name = "hirarchy_name")
    private String hirarchyname;

    @Column(name = "parent_hirarchy")
    private String parenthirarchy;

    @Column(name = "hirarchy_status")
    private String hirarchystatus;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHirarchyuuid() { return hirarchyuuid; }
    public void setHirarchyuuid(String hirarchyuuid) { this.hirarchyuuid = hirarchyuuid; }

    public String getHirarchylevel() { return hirarchylevel; }
    public void setHirarchylevel(String hirarchylevel) { this.hirarchylevel = hirarchylevel; }

    public String getClientuuid() { return clientuuid; }
    public void setClientuuid(String clientuuid) { this.clientuuid = clientuuid; }

    public String getPartneruuid() { return partneruuid; }
    public void setPartneruuid(String partneruuid) { this.partneruuid = partneruuid; }

    public String getChanneluuid() { return channeluuid; }
    public void setChanneluuid(String channeluuid) { this.channeluuid = channeluuid; }

    public String getHirarchyname() { return hirarchyname; }
    public void setHirarchyname(String hirarchyname) { this.hirarchyname = hirarchyname; }

    public String getParenthirarchy() { return parenthirarchy; }
    public void setParenthirarchy(String parenthirarchy) { this.parenthirarchy = parenthirarchy; }

    public String getHirarchystatus() { return hirarchystatus; }
    public void setHirarchystatus(String hirarchystatus) { this.hirarchystatus = hirarchystatus; }
}
