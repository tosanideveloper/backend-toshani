package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "th_entity_master")
public class EntityMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_uuid")
    private String entityUuid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_uuid", referencedColumnName = "client_uuid",
            foreignKey = @ForeignKey(name = "fk_entity_client_uuid"))
    private ClientMasterEntity clientMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_uuid", referencedColumnName = "partner_uuid",
            foreignKey = @ForeignKey(name = "fk_entity_partner_uuid"))
    private PartnerMasterEntity partnerMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_uuid", referencedColumnName = "channel_uuid",
            foreignKey = @ForeignKey(name = "fk_entity_channel_uuid"))
    private ChannelMasterEntity channelMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hirarchy_uuid", referencedColumnName = "hirarchy_uuid",
            foreignKey = @ForeignKey(name = "fk_entity_hierarchy_uuid"))
    private HierarchyMasterEntity hierarchyMaster;

    @Column(name = "parent_hirarchy")
    private String parentHierarchy;

    @Column(name = "hirarchy_level")
    private String hirarchyLevel;

    @Column(name = "entity_name")
    private String entityName;

    @Column(name = "parent_entity")
    private String parentEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityUuid() {
        return entityUuid;
    }

    public void setEntityUuid(String entityUuid) {
        this.entityUuid = entityUuid;
    }

    public ClientMasterEntity getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(ClientMasterEntity clientMaster) {
        this.clientMaster = clientMaster;
    }

    public PartnerMasterEntity getPartnerMaster() {
        return partnerMaster;
    }

    public void setPartnerMaster(PartnerMasterEntity partnerMaster) {
        this.partnerMaster = partnerMaster;
    }

    public ChannelMasterEntity getChannelMaster() {
        return channelMaster;
    }

    public void setChannelMaster(ChannelMasterEntity channelMaster) {
        this.channelMaster = channelMaster;
    }

    public HierarchyMasterEntity getHierarchyMaster() {
        return hierarchyMaster;
    }

    public void setHierarchyMaster(HierarchyMasterEntity hierarchyMaster) {
        this.hierarchyMaster = hierarchyMaster;
    }

    public String getParentHierarchy() {
        return parentHierarchy;
    }

    public void setParentHierarchy(String parentHierarchy) {
        this.parentHierarchy = parentHierarchy;
    }

    public String getHirarchyLevel() {
        return hirarchyLevel;
    }

    public void setHirarchyLevel(String hirarchyLevel) {
        this.hirarchyLevel = hirarchyLevel;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(String parentEntity) {
        this.parentEntity = parentEntity;
    }
}
