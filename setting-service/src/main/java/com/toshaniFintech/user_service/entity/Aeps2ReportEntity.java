package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name ="th_aeps2_report")
public class AEPS2ReportEntity extends BaseEntity {
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "partner_name", length = 100)
    private String partnerName;

    @Column(name = "partner_id", length = 50)
    private String partnerId;

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @Column(name = "order_id", length = 100)
    private String orderId;

    @Column(name = "merchant_code", length = 50)
    private String merchantCode;

    @Column(name = "api_transaction_id", length = 100)
    private String apiTransactionId;

    public AEPS2ReportEntity() {
    }

    public AEPS2ReportEntity(LocalDateTime transactionDate,
                             String partnerName,
                             String partnerId,
                             String transactionId,
                             String orderId,
                             String merchantCode,
                             String apiTransactionId) {

        this.transactionDate = transactionDate;
        this.partnerName = partnerName;
        this.partnerId = partnerId;
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.merchantCode = merchantCode;
        this.apiTransactionId = apiTransactionId;
    }

}
