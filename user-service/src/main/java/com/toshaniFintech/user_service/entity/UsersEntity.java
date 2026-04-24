package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_uuid")
    private String useruuid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email_id")
    private String emailid;

    @Column(name = "mobile_no")
    private String mobileno;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "middle_name")
    private String middlename;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "entity_uuid")
    private String entityuuid;

    @Column(name = "entity_admin")
    private String entityadmin;

    @Column(name = "role")
    private String role;

    @Column(name = "role_privilage_uuid")
    private String roleprivilageuuid;

    @Column(name = "user_type")
    private String usertype;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUseruuid() { return useruuid; }
    public void setUseruuid(String useruuid) { this.useruuid = useruuid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmailid() { return emailid; }
    public void setEmailid(String emailid) { this.emailid = emailid; }

    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getMiddlename() { return middlename; }
    public void setMiddlename(String middlename) { this.middlename = middlename; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEntityuuid() { return entityuuid; }
    public void setEntityuuid(String entityuuid) { this.entityuuid = entityuuid; }

    public String getEntityadmin() { return entityadmin; }
    public void setEntityadmin(String entityadmin) { this.entityadmin = entityadmin; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getRoleprivilageuuid() { return roleprivilageuuid; }
    public void setRoleprivilageuuid(String roleprivilageuuid) { this.roleprivilageuuid = roleprivilageuuid; }

    public String getUsertype() { return usertype; }
    public void setUsertype(String usertype) { this.usertype = usertype; }
}
