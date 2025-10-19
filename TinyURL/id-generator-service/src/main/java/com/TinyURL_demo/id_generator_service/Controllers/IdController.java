package com.TinyURL_demo.id_generator_service.Controllers;

import com.TinyURL_demo.id_generator_service.Services.GenerationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate")
public class IdController {

    private final GenerationService generationService;


    public IdController(GenerationService generationService) {
        this.generationService = generationService;
    }

    @GetMapping("/id")
    public ResponseEntity<Long> GenerateId(){
        return ResponseEntity.ok(generationService.GenerateId());
    }


}
