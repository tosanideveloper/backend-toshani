package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
@Entity
@Table(name = "th_aeps3_report")
public class AEPS3ReportEntity extends BaseEntity {

        @Column(name = "partner_name", length = 100)
        private String partnerName;

        @Column(name = "partner_id", length = 100)
        private String partnerId;

        @Column(name = "transaction_id", length = 100)
        private String transactionId;

        @Column(name = "order_id", length = 100)
        private String orderId;

        @Column(name = "merchant_code", length = 50)
        private String merchantCode;

        @Column(name = "bank_name", length = 100)
        private String bankName;

        @Column(name = "aadhaar_no", length = 20)
        private String aadhaarNo;

        @Column(name = "transaction_type", length = 50)
        private String transactionType;

        @Column(name = "amount", precision = 15, scale = 2)
        private BigDecimal amount;

        @Column(name = "utr", length = 100)
        private String utr;

        @Column(name = "commission", precision = 15, scale = 2)
        private BigDecimal commission;

        @Column(name = "tds", precision = 15, scale = 2)
        private BigDecimal tds;

        @Column(name = "charges", precision = 15, scale = 2)
        private BigDecimal charges;

        @Column(name = "gst", precision = 15, scale = 2)
        private BigDecimal gst;

        @Column(name = "transaction_date")
        private LocalDateTime transactionDate;

        public AEPS3ReportEntity() {
        }

        public AEPS3ReportEntity(String partnerName,
                                 String partnerId,
                                 String transactionId,
                                 String orderId,
                                 String merchantCode,
                                 String bankName,
                                 String aadhaarNo,
                                 String transactionType,
                                 BigDecimal amount,
                                 String utr,
                                 BigDecimal commission,
                                 BigDecimal tds,
                                 BigDecimal charges,
                                 BigDecimal gst,
                                 LocalDateTime transactionDate) {

            this.partnerName = partnerName;
            this.partnerId = partnerId;
            this.transactionId = transactionId;
            this.orderId = orderId;
            this.merchantCode = merchantCode;
            this.bankName = bankName;
            this.aadhaarNo = aadhaarNo;
            this.transactionType = transactionType;
            this.amount = amount;
            this.utr = utr;
            this.commission = commission;
            this.tds = tds;
            this.charges = charges;
            this.gst = gst;
            this.transactionDate = transactionDate;
        }
    }
