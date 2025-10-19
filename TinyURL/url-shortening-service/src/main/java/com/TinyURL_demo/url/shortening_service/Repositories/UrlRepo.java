package com.TinyURL_demo.url.shortening_service.Repositories;

import com.TinyURL_demo.url.shortening_service.Models.MyUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepo extends JpaRepository<MyUrl , Long> {
    Optional<MyUrl> findByLongURL(String longURL);



}
