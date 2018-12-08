package com.donggoos.lotto.draw.service;

import com.donggoos.lotto.draw.domain.Draw;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:properties/common.properties")
@ActiveProfiles("test")
public class DrawWithApiServiceTest {

    @Autowired
    private DrawWithApiService drawWithApiService;


    @Test
    public void findOne() {
        Draw one = drawWithApiService.findOne(400l);
        System.out.println(one);
    }
}