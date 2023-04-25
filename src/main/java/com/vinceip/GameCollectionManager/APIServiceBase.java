package com.vinceip.GameCollectionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;

@Service
public class APIServiceBase {
    @Value("${api.username}")
    protected String apiBaseUrl;
    @Value("${api.client-id")
    protected String clientId;
    @Value("${api.authorization")
    protected String authorization;

    protected RestTemplate restTemplate;

    @Autowired
    public APIServiceBase(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
}
