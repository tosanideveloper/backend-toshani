package com.toshaniFintech.user_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "th_channel_master")
public class ChannelMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "channel_uuid")
    private String channelUuid;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_uuid",
            referencedColumnName = "client_uuid",
            foreignKey = @ForeignKey(name = "fk_channel_client_uuid")
    )
    private ClientMasterEntity clientMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "partner_uuid",
            referencedColumnName = "partner_uuid",
            foreignKey = @ForeignKey(name = "fk_channel_partner_uuid")
    )
    private PartnerMasterEntity partnerMaster;

    @Column(name = "channel_name")
    private String channelName;

    @Column(name = "channel_status")
    private String channelStatus;

    public ChannelMasterEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelUuid() {
        return channelUuid;
    }

    public void setChannelUuid(String channelUuid) {
        this.channelUuid = channelUuid;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(String channelStatus) {
        this.channelStatus = channelStatus;
    }
}