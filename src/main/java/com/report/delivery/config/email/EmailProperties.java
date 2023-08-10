package com.report.delivery.config.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "email")
public class EmailProperties {

    private String host;
    private String protocol;
    private Integer port;
    private String username;
    private String password;
    private Boolean isDebug;

}