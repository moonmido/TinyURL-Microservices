package com.TinyURL_demo.url.shortening_service.Configurations;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BloomFiltersConfig {

    @Bean
    public BloomFilter<String> BloomFilter(){
        return BloomFilter
                .create(Funnels.unencodedCharsFunnel(), 1_000_000, 0.01);
    }

}
