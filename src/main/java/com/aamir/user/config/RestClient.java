package com.aamir.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClient {

    @Bean
    @LoadBalanced // use services instance name instead of hostname and port no
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
