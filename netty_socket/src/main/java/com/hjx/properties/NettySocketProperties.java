package com.hjx.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix = "hjx-coding")
public class NettySocketProperties {

    private String socketHostname;

    private int socketPort;
}
