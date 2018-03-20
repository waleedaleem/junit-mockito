package com.walid.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientImpl implements HttpClient {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String get(String url) {
        String response = restTemplate.getForEntity(url, String.class).getBody();
        return response;
    }
}
