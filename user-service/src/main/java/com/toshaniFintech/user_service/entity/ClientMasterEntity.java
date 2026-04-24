
package com.toshaniFintech.user_service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "th_client_master")
public class ClientMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_uuid")
    private String clientUuid;

    @Column(name = "client_secret_key")
    private String clientSecretKey;

    @Column(name = "client_status")
    private String clientStatus;

    @Column(name = "client_name")
    private String clientName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientUuid() { return clientUuid; }
    public void setClientUuid(String clientUuid) { this.clientUuid = clientUuid; }
    public String getClientSecretKey() { return clientSecretKey; }
    public void setClientSecretKey(String clientSecretKey) { this.clientSecretKey = clientSecretKey; }
    public String getClientStatus() { return clientStatus; }
    public void setClientStatus(String clientStatus) { this.clientStatus = clientStatus; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
}
