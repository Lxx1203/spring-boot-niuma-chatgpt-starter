package com.niuma.project.autoconfig;

import com.niuma.project.properties.NiuMaChatGptConfiguration;
import niuma.com.chatgpt.ChatGPTClientBuilder;
import niuma.com.chatgpt.GPTClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(NiuMaChatGptConfiguration.class)
public class AutoConfiguration {
    @Bean
    public GPTClient gptClient(NiuMaChatGptConfiguration niuMaChatGptConfiguration, ChatGPTClientBuilder chatGPTClientBuilder) {
        GPTClient client = chatGPTClientBuilder
                .key(niuMaChatGptConfiguration.getKey()) // 设置 key，必备
                .proxy(niuMaChatGptConfiguration.getProxyHost(), niuMaChatGptConfiguration.getProxyPort()).builder();
        if(niuMaChatGptConfiguration.getUrl()!=null){
            client.setUrl(niuMaChatGptConfiguration.getUrl());
        }
        return client;
    }

    @Bean
    public ChatGPTClientBuilder chatGPTClientBuilder() {
        return new ChatGPTClientBuilder();
    }
}
