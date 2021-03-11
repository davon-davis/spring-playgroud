package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordConfig {
    @Bean
    public WordCounter getWC(){
        return new WordCounter();
    }
}
