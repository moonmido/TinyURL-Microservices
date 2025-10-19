package com.TinyURL_demo.url.shortening_service.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenerateIdService {

    private final RestTemplate restTemplate;

    public final String ID_GEN_URL="http://id-generator-service";

    public GenerateIdService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Long GetID(){
        ResponseEntity<Long> forEntity = restTemplate.getForEntity(ID_GEN_URL + "/api/generate/id", Long.class);
        return forEntity.getBody();
    }


}
