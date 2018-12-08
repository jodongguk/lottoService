package com.donggoos.lotto;

import com.donggoos.lotto.draw.domain.LottoResult;
import com.donggoos.lotto.draw.infrastructure.model.LottoInfo;
import com.donggoos.lotto.draw.service.DrawService;
import java.util.Arrays;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainTestData {


    @Bean
    public ApplicationRunner drawTestData(DrawService drawService) {
        return args -> {
            LottoInfo draw = new LottoInfo(1l, "20180901", "Y",
                1,2,3,4,5,6,7, 100l,
                Arrays.asList(
                    new LottoResult("FIRST", "adsf", "aaaa", "bbbb"),
                    new LottoResult("SECOND", "adsf", "aaaa", "bbbb"),
                    new LottoResult("THIRD", "adsf", "aaaa", "bbbb"),
                    new LottoResult("FOURTH", "adsf", "aaaa", "bbbb")
                )
            );

            drawService.create(draw);
        };
    }

}
