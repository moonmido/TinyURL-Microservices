package com.TinyURL_demo.url.shortening_service.Services;

import com.TinyURL_demo.url.shortening_service.Configurations.BloomFiltersConfig;
import com.TinyURL_demo.url.shortening_service.Models.MyUrl;
import com.TinyURL_demo.url.shortening_service.Repositories.UrlRepo;
import com.google.common.hash.BloomFilter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class shorteningService {

    private final GenerateIdService generateIdService;

    private final UrlRepo urlRepo;
    private final BloomFilter<String> bloomFilter;


    public shorteningService(GenerateIdService generateIdService, UrlRepo urlRepo, BloomFilter<String> bloomFilter) {
        this.generateIdService = generateIdService;
        this.urlRepo = urlRepo;
        this.bloomFilter = bloomFilter;
    }

    public String shortneringUrl(String longURL) {
        if (longURL == null || longURL.isEmpty())
            throw new IllegalArgumentException("longURL is empty");

        // If it already exists, just return it
        if (bloomFilter.mightContain(longURL)) {
            Optional<MyUrl> existing = urlRepo.findByLongURL(longURL);
            if (existing.isPresent()) return existing.get().getShortURL();
        }

        // Otherwise, create a new one
        Long generatedId = generateIdService.GetID();
        String shortURL = encode(generatedId);

        MyUrl myUrl = new MyUrl();
        myUrl.setLongURL(longURL);
        myUrl.setShortURL(shortURL);

        urlRepo.save(myUrl);
        bloomFilter.put(longURL);

        return shortURL;
    }


    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = 62;

    // Encode a long number to Base62
    private String encode(long value) {
        StringBuilder sb = new StringBuilder();
        if (value == 0) {
            return "0";
        }
        while (value > 0) {
            int remainder = (int) (value % BASE);
            sb.append(BASE62.charAt(remainder));
            value = value / BASE;
        }
        return sb.reverse().toString();
    }

    public String GetShortUrl(String longURL){
        if(longURL==null || longURL.isEmpty()) throw new IllegalArgumentException("longUrl is empty");
        if(bloomFilter.mightContain(longURL)){
            Optional<MyUrl> byLongUrl = urlRepo.findByLongURL(longURL);
            if(byLongUrl.isPresent()) return byLongUrl.get().getShortURL();
        }
        throw new IllegalStateException("URL not found in system");
    }




}
