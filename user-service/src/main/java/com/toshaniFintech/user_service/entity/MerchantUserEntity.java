package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class MerchantUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_uuid")
    private String merchantuuid;

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

    @Column(name = "business_name")
    private String businessname;

    @Column(name = "business_state")
    private String businessstate;

    @Column(name = "business_city")
    private String businesscity;

    @Column(name = "business_pin")
    private String businesspin;

    @Column(name = "gst")
    private String gst;

    @Column(name = "pan")
    private String pan;

    @Column(name = "communication_state")
    private String communicationstate;

    @Column(name = "communication_city")
    private String communicationcity;

    @Column(name = "communication_pin")
    private String communicationpin;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMerchantuuid() { return merchantuuid; }
    public void setMerchantuuid(String merchantuuid) { this.merchantuuid = merchantuuid; }

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

    public String getBusinessname() { return businessname; }
    public void setBusinessname(String businessname) { this.businessname = businessname; }

    public String getBusinessstate() { return businessstate; }
    public void setBusinessstate(String businessstate) { this.businessstate = businessstate; }

    public String getBusinesscity() { return businesscity; }
    public void setBusinesscity(String businesscity) { this.businesscity = businesscity; }

    public String getBusinesspin() { return businesspin; }
    public void setBusinesspin(String businesspin) { this.businesspin = businesspin; }

    public String getGst() { return gst; }
    public void setGst(String gst) { this.gst = gst; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getCommunicationstate() { return communicationstate; }
    public void setCommunicationstate(String communicationstate) { this.communicationstate = communicationstate; }

    public String getCommunicationcity() { return communicationcity; }
    public void setCommunicationcity(String communicationcity) { this.communicationcity = communicationcity; }

    public String getCommunicationpin() { return communicationpin; }
    public void setCommunicationpin(String communicationpin) { this.communicationpin = communicationpin; }
}
