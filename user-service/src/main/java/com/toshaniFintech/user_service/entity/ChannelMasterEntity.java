package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
public class ChannelMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "channel_uuid")
    private String channeluuid;

    @Column(name = "client_uuid")
    private String clientuuid;

    @Column(name = "partner_uuid")
    private String partneruuid;

    @Column(name = "channel_name")
    private String channelname;

    @Column(name = "channel_status")
    private String channelstatus;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getChanneluuid() { return channeluuid; }
    public void setChanneluuid(String channeluuid) { this.channeluuid = channeluuid; }

    public String getClientuuid() { return clientuuid; }
    public void setClientuuid(String clientuuid) { this.clientuuid = clientuuid; }

    public String getPartneruuid() { return partneruuid; }
    public void setPartneruuid(String partneruuid) { this.partneruuid = partneruuid; }

    public String getChannelname() { return channelname; }
    public void setChannelname(String channelname) { this.channelname = channelname; }

    public String getChannelstatus() { return channelstatus; }
    public void setChannelstatus(String channelstatus) { this.channelstatus = channelstatus; }
}
