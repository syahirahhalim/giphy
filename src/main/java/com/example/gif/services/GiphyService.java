package com.example.gif.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.gif.models.Giphy;

@Service
public class GiphyService {

    private static final String URL = "https://api.giphy.com/v1/gifs/search";

    @Value("${giphy.api.key}")
    private String apiKey;

    private boolean hasKey;

    @PostConstruct
    private void init() {
        hasKey = null != apiKey;
    }

    public Optional<List<Giphy>> findGiphy(String q, String rating, String width) {

        String giphyUrl = UriComponentsBuilder.fromUriString(URL)
                .queryParam("api_key", apiKey)
                .queryParam("q", q)
                .queryParam("rating", rating)
                .toUriString();

        RequestEntity<Void> req = RequestEntity
                .get(giphyUrl)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = null;

        try {
            resp = template.exchange(req, String.class);
        } catch (Exception e) {
          
            e.printStackTrace();
        }

        if (resp.getStatusCodeValue() >= 400) {
            return Optional.empty();
        }

        try {

            List<Giphy> giphy = Giphy.create(resp.getBody(), width);
            return Optional.of(giphy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    
    public Optional<List<Giphy>> findGiphy(String q, Integer limit, String width) {

        String giphyUrl = UriComponentsBuilder.fromUriString(URL)
                .queryParam("api_key", apiKey)
                .queryParam("q", q)
                .queryParam("limit", limit)
                .toUriString();

        RequestEntity<Void> req = RequestEntity
                .get(giphyUrl)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = null;

        try {
            resp = template.exchange(req, String.class);
        } catch (Exception e) {
          
            e.printStackTrace();
        }

        if (resp.getStatusCodeValue() >= 400) {
            return Optional.empty();
        }

        try {

            List<Giphy> giphy = Giphy.create(resp.getBody(), width);
            return Optional.of(giphy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<List<Giphy>> findGiphy(String q, Integer limit, Integer offset, String rating, String lang,
            String width) {

        String giphyUrl = UriComponentsBuilder.fromUriString(URL)
                .queryParam("api_key", apiKey)
                .queryParam("q", q)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .queryParam("rating", rating)
                .queryParam("lang", lang)
                .toUriString();

        RequestEntity<Void> req = RequestEntity
                .get(giphyUrl)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = null;

        try {
            resp = template.exchange(req, String.class);
        } catch (Exception e) {
           
            e.printStackTrace();
        }

        if (resp.getStatusCodeValue() >= 400) {
            return Optional.empty();
        }

        try {

            List<Giphy> giphy = Giphy.create(resp.getBody(), width);
            return Optional.of(giphy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    public List<String> getGiphs(String string) {
        return null;
    }
}