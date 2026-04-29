package com.toshaniFintech.user_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "th_user")
public class UserMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "partner_uuid")
    private String partnerUuid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_uuid", referencedColumnName = "entity_uuid",
            foreignKey = @ForeignKey(name = "fk_user_entity_uuid"))
    private EntityMasterEntity entityMaster;

    @Column(name = "entity_admin")
    private String entityAdmin;

    @Column(name = "role")
    private String role;

    @Column(name = "role_privilage_uuid")
    private String rolePrivilageUuid;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "settlement_type")
    private String settlementType;

    public UserMasterEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getPartnerUuid() {
        return partnerUuid;
    }

    public void setPartnerUuid(String partnerUuid) {
        this.partnerUuid = partnerUuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EntityMasterEntity getEntityMaster() {
        return entityMaster;
    }

    public void setEntityMaster(EntityMasterEntity entityMaster) {
        this.entityMaster = entityMaster;
    }

    public String getEntityAdmin() {
        return entityAdmin;
    }

    public void setEntityAdmin(String entityAdmin) {
        this.entityAdmin = entityAdmin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRolePrivilageUuid() {
        return rolePrivilageUuid;
    }

    public void setRolePrivilageUuid(String rolePrivilageUuid) {
        this.rolePrivilageUuid = rolePrivilageUuid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }
}
