package com.niuma.project.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@ConfigurationProperties(prefix = "niuma.chatgpt.client")
public class NiuMaChatGptConfiguration {
    private String url;
    private String key;
    private String proxyHost;
    private Integer proxyPort;
}
