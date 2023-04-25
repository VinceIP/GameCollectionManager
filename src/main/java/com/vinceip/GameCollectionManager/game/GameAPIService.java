package com.vinceip.GameCollectionManager.game;

import com.vinceip.GameCollectionManager.APIService;
import com.vinceip.GameCollectionManager.APIServiceBase;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class GameAPIService extends APIServiceBase implements APIService {
    public GameAPIService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Object get(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        httpHeaders.set("Client-ID", clientId);
        httpHeaders.set("Authorization", authorization);

        HttpEntity<String> request = new HttpEntity<>(query, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(API_BASE_URL, HttpMethod.POST, request, String.class);

        String responseBody = response.getBody();

        assert responseBody != null;
        System.out.println(responseBody);

        return null;
    }
}
