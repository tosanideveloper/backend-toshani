package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "th_hirarchy_master")
public class HierarchyMasterEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "hirarchy_uuid")
        private String hirarchyUuid;

        @Column(name = "hirarchy_level")
        private String hirarchyLevel;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(
                name = "client_uuid",
                referencedColumnName = "client_uuid",
                foreignKey = @ForeignKey(name = "fk_hierarchy_client_uuid")
        )
        private ClientMasterEntity clientMaster;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(
                name = "partner_uuid",
                referencedColumnName = "partner_uuid",
                foreignKey = @ForeignKey(name = "fk_hierarchy_partner_uuid")
        )
        private PartnerMasterEntity partnerMaster;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(
                name = "channel_uuid",
                referencedColumnName = "channel_uuid",
                foreignKey = @ForeignKey(name = "fk_hierarchy_channel_uuid")
        )
        private ChannelMasterEntity channelMaster;

        @Column(name = "hirarchy_name")
        private String hirarchyName;

        @Column(name = "parent_hirarchy")
        private String parentHierarchy;

        @Column(name = "hirarchy_status")
        private String hirarchyStatus;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getHirarchyUuid() {
            return hirarchyUuid;
        }

        public void setHirarchyUuid(String hirarchyUuid) {
            this.hirarchyUuid = hirarchyUuid;
        }

        public String getHirarchyLevel() {
            return hirarchyLevel;
        }

        public void setHirarchyLevel(String hirarchyLevel) {
            this.hirarchyLevel = hirarchyLevel;
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

        public String getHirarchyName() {
            return hirarchyName;
        }

        public void setHirarchyName(String hirarchyName) {
            this.hirarchyName = hirarchyName;
        }

        public String getParentHierarchy() {
            return parentHierarchy;
        }

        public void setParentHierarchy(String parentHierarchy) {
            this.parentHierarchy = parentHierarchy;
        }

        public String getHirarchyStatus() {
            return hirarchyStatus;
        }

        public void setHirarchyStatus(String hirarchyStatus) {
            this.hirarchyStatus = hirarchyStatus;
        }
    }
