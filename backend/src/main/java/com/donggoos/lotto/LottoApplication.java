package com.donggoos.lotto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@Configuration // JavaConfig
//@EnableAutoConfiguration // 자동설정 활성화
//@ComponentScan // 해당위치부터 컴포넌트 스캔 진행
@SpringBootApplication
public class LottoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LottoApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
