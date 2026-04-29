package com.toshaniFintech.user_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "th_partner_master")
public class PartnerMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partner_uuid")
    private String partnerUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_uuid",
            referencedColumnName = "client_uuid",
            foreignKey = @ForeignKey(name = "fk_partner_client_uuid")
    )
    private ClientMasterEntity clientMaster;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "partner_business_name")
    private String partnerBusinessName;

    @Column(name = "partner_type")
    private String partnerType;

    @Column(name = "partner_status")
    private String partnerStatus;

    @Column(name = "created_date")
    private String createdDate;

    public PartnerMasterEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerUuid() {
        return partnerUuid;
    }

    public void setPartnerUuid(String partnerUuid) {
        this.partnerUuid = partnerUuid;
    }

    public ClientMasterEntity getClientMaster() {
        return clientMaster;
    }

    public void setClientMaster(ClientMasterEntity clientMaster) {
        this.clientMaster = clientMaster;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerBusinessName() {
        return partnerBusinessName;
    }

    public void setPartnerBusinessName(String partnerBusinessName) {
        this.partnerBusinessName = partnerBusinessName;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    public String getPartnerStatus() {
        return partnerStatus;
    }

    public void setPartnerStatus(String partnerStatus) {
        this.partnerStatus = partnerStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}