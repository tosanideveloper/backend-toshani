
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

    @Column(name = "client_uuid")
    private String clientUuid;

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "partner_business_name")
    private String partnerBusinessName;

    @Column(name = "partner_type")
    private String partnerType;

    @Column(name = "partner_status")
    private String partnerStatus;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPartnerUuid() { return partnerUuid; }
    public void setPartnerUuid(String partnerUuid) { this.partnerUuid = partnerUuid; }
    public String getClientUuid() { return clientUuid; }
    public void setClientUuid(String clientUuid) { this.clientUuid = clientUuid; }
    public String getPartnerName() { return partnerName; }
    public void setPartnerName(String partnerName) { this.partnerName = partnerName; }
    public String getPartnerBusinessName() { return partnerBusinessName; }
    public void setPartnerBusinessName(String partnerBusinessName) { this.partnerBusinessName = partnerBusinessName; }
    public String getPartnerType() { return partnerType; }
    public void setPartnerType(String partnerType) { this.partnerType = partnerType; }
    public String getPartnerStatus() { return partnerStatus; }
    public void setPartnerStatus(String partnerStatus) { this.partnerStatus = partnerStatus; }
}
