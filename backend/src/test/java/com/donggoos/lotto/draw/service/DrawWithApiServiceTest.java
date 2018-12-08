package com.donggoos.lotto.draw.service;

import static org.junit.Assert.*;

import com.donggoos.lotto.draw.domain.Draw;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "lotto.api.url=https://www.geniecontents.com/api/v1")
@ActiveProfiles("test")
public class DrawWithApiServiceTest {

    @Autowired
    private DrawWithApiService drawWithApiService;

    @Test
    public void test() {
        Draw one = drawWithApiService.findOne(400l);
        System.out.println(one);

        Draw two = drawWithApiService.findOne(400l);
        System.out.println(two);
    }
}