package com.TinyURL_demo.id_generator_service.Services;

import cn.hutool.core.lang.Snowflake;
import org.springframework.stereotype.Service;

@Service
public class GenerationService {

    private final Snowflake snowflake;

    public GenerationService(Snowflake snowflake) {
        this.snowflake =  snowflake;
    }

    public Long GenerateId(){
        return snowflake.nextId();
    }

}
