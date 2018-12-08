package com.donggoos.lotto.draw.infrastructure;

import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.infrastructure.model.LottoInfo;
import java.io.IOException;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class ApiServiceTest {

    private ApiService apiService;

    @Before
    public void setup() {
        apiService = new ApiService(new RestTemplate(), "https://www.geniecontents.com/api/v1");
    }

    @Test
    public void lottoTest() throws IOException {
        Optional<LottoInfo> lotto = apiService.lotto(500l);
        System.out.println(lotto);

        lotto.ifPresent(l -> {
            Draw draw = l.create();
            System.out.println(draw);
        });
    }

    @Test
    public void lotto404Test() throws IOException {
        Optional<LottoInfo> lotto = apiService.lotto(102140l);
        System.out.println(lotto.isPresent());
    }
}