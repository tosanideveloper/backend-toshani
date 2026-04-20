package com.toshaniFintech.notification.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private MailConfig mail = new MailConfig();
    private Rabbitmq rabbitmq = new Rabbitmq();
    private Sms sms = new Sms();

    @Data
    public static class MailConfig {
        private String from;
        private String supportFrom;
    }

    @Data
    public static class Rabbitmq {
        private Queue queues = new Queue();
    }

    @Data
    public static class Queue {
        private QueueInfo sms = new QueueInfo();
        private QueueInfo email = new QueueInfo();
        private QueueInfo rollback = new QueueInfo();
        private QueueInfo bulkupload = new QueueInfo();
    }

    @Data
    public static class QueueInfo {
        private String name;
        private String key;
        private String exchange;
    }

    @Data
    public static class Sms {
        private String authToken;
        private String sid;
        private String fromMobile;
    }
}