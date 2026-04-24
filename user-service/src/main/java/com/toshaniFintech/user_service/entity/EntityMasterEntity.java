package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class EntityMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_uuid")
    private String entityuuid;

    @Column(name = "client_uuid")
    private String clientuuid;

    @Column(name = "partner_uuid")
    private String partneruuid;

    @Column(name = "channel_uuid")
    private String channeluuid;

    @Column(name = "hirarchy_uuid")
    private String hirarchyuuid;

    @Column(name = "parent_hirarchy")
    private String parenthirarchy;

    @Column(name = "hirarchy_level")
    private String hirarchylevel;

    @Column(name = "entity_name")
    private String entityname;

    @Column(name = "parent_entity")
    private String parententity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntityuuid() { return entityuuid; }
    public void setEntityuuid(String entityuuid) { this.entityuuid = entityuuid; }

    public String getClientuuid() { return clientuuid; }
    public void setClientuuid(String clientuuid) { this.clientuuid = clientuuid; }

    public String getPartneruuid() { return partneruuid; }
    public void setPartneruuid(String partneruuid) { this.partneruuid = partneruuid; }

    public String getChanneluuid() { return channeluuid; }
    public void setChanneluuid(String channeluuid) { this.channeluuid = channeluuid; }

    public String getHirarchyuuid() { return hirarchyuuid; }
    public void setHirarchyuuid(String hirarchyuuid) { this.hirarchyuuid = hirarchyuuid; }

    public String getParenthirarchy() { return parenthirarchy; }
    public void setParenthirarchy(String parenthirarchy) { this.parenthirarchy = parenthirarchy; }

    public String getHirarchylevel() { return hirarchylevel; }
    public void setHirarchylevel(String hirarchylevel) { this.hirarchylevel = hirarchylevel; }

    public String getEntityname() { return entityname; }
    public void setEntityname(String entityname) { this.entityname = entityname; }

    public String getParententity() { return parententity; }
    public void setParententity(String parententity) { this.parententity = parententity; }
}
