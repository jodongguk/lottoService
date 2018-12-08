package com.donggoos.lotto.draw.infrastructure;


import com.donggoos.lotto.draw.infrastructure.model.ApiResponse;
import com.donggoos.lotto.draw.infrastructure.model.LottoInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ApiService {

    private final RestTemplate restTemplate;
    private final String LOTTO_API_URL;

    public ApiService(RestTemplate restTemplate, @Value(value = "${lotto.api.url:''}") String lottoApiUrl) {
        this.restTemplate = restTemplate;
        this.LOTTO_API_URL = lottoApiUrl;
    }

    public Optional<LottoInfo> lotto(Long drawNo) {
        try {
            ApiResponse<LottoInfo> lottoInfoApiResponse = restTemplate.exchange(
                    String.format("%s%s%s", LOTTO_API_URL, "/lotto?drawNo=", drawNo),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ApiResponse<LottoInfo>>() {}).getBody();

            return Optional.of(lottoInfoApiResponse.getBody());
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
