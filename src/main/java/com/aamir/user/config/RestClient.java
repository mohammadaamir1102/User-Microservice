package com.aamir.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClient {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
