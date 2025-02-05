package com.challenge.pet.love.infra.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RestTemplateConfig.class)
public class RestTemplateConfigTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void restTemplateBean_isCreated() {
        assertNotNull(restTemplate);
    }

    @Configuration
    static class TestConfig {
        @Bean
        public RestTemplate restTemplateTest() {
            return new RestTemplate();
        }
    }
}