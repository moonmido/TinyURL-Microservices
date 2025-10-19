package com.TinyURL_demo.id_generator_service.Configurations;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig {

    private static final long WORKER_ID = 1;
    private static final long DATACENTER_ID = 1;

    @Bean
    public Snowflake snowflake() {
        return IdUtil.getSnowflake(WORKER_ID, DATACENTER_ID);
    }
}

