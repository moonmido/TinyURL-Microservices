package com.TinyURL_demo.url.shortening_service.Controllers;

import com.TinyURL_demo.url.shortening_service.Services.shorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlShortenerController {

    private final shorteningService shorteningService;

    @Autowired
    public UrlShortenerController(shorteningService shorteningService) {
        this.shorteningService = shorteningService;
    }

    // ✅ Create short URL (cache result)
    @PostMapping("/shorten")
    @CachePut(value = "urls", key = "#longURL")
    public ResponseEntity<?> createShortUrl(@RequestParam String longURL) {
        try {
            String shortUrl = shorteningService.shortneringUrl(longURL);
            return ResponseEntity.ok(shortUrl);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error while shortening URL: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    @Cacheable(value = "urls", key = "#longURL")
    public ResponseEntity<?> getShortUrl(@RequestParam String longURL) {
        try {
            String shortUrl = shorteningService.GetShortUrl(longURL);
            return ResponseEntity.ok(shortUrl);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error retrieving URL: " + e.getMessage());
        }
    }

}
