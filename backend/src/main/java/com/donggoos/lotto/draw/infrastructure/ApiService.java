package com.donggoos.lotto.draw.infrastructure;


import com.donggoos.lotto.draw.infrastructure.model.ApiResponse;
import com.donggoos.lotto.draw.infrastructure.model.LottoInfo;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ApiService {

    private RestTemplate restTemplate;
    private final String LOTTO_API_URL;

    public ApiService(RestTemplate restTemplate, @Value(value = "${lotto.api.url}") String lottoApiUrl) {
        this.restTemplate = restTemplate;
        this.LOTTO_API_URL = lottoApiUrl;
    }

    //    @Autowired
//    private DrawRepository drawRepository;

    public Optional<LottoInfo> lotto(Long drawNo) {
        log.debug("api search drawNo : {}", drawNo);
        try {
            ApiResponse body = restTemplate
                .getForEntity(String.format("%s%s%s", LOTTO_API_URL, "/lotto?drawNo=", drawNo), ApiResponse.class).getBody();
            return Optional.of(body.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
/*
    public void getApiDrawOne(Long drawNo) throws IOException {
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

        System.out.println(draw);

        //draw.

//        drawRepository.save(draw);
//        return drawRepository.findById(1L);
    }*/
}
