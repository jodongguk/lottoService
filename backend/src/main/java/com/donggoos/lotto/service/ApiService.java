package com.donggoos.lotto.service;


import com.donggoos.lotto.model.ApiRequest;
import com.donggoos.lotto.model.Draw;
import com.donggoos.lotto.repositories.DrawRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${lotto.api.url}")
    private String LOTTO_API_URL;

    @Autowired
    private DrawRepository drawRepository;

    public Optional<Draw> getApiDrawOne(Long drawNo) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        ApiRequest drawRequest = restTemplate.exchange(String.format("%s%s%s", LOTTO_API_URL, "/lotto?drawNo=", drawNo), HttpMethod.GET, entity, ApiRequest.class).getBody();
        ApiRequest winningRequest = restTemplate.exchange(String.format("%s%s%s", LOTTO_API_URL, "/lotto/winning/places?drawNo=", drawNo), HttpMethod.GET, entity, ApiRequest.class).getBody();

        Map<String, Object> drawBody = drawRequest.getBody();
        Map<String, Object> winningBody = winningRequest.getBody();

        winningBody.forEach((k, v) -> drawBody.putIfAbsent(k, v));

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);


        Draw draw = mapper.convertValue(drawBody, Draw.class);

        //draw.

        drawRepository.save(draw);
        return drawRepository.findById(1L);
    }
}
