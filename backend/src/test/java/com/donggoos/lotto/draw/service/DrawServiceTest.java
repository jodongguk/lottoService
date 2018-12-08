package com.donggoos.lotto.draw.service;


import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.domain.LottoResult;
import com.donggoos.lotto.draw.infrastructure.model.LottoInfo;
import java.util.Arrays;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawServiceTest {

    @Autowired
    private DrawService drawService;

    @Test
    @Transactional
    public void test() {

        LottoInfo draw = new LottoInfo(1l, "20180901", "Y",
            1,2,3,4,5,6,7, 100l,
            Arrays.asList(
                new LottoResult("FIRST", "adsf", "aaaa", "bbbb"),
                new LottoResult("SECOND", "adsf", "aaaa", "bbbb"),
                new LottoResult("THIRD", "adsf", "aaaa", "bbbb"),
                new LottoResult("FOURTH", "adsf", "aaaa", "bbbb")
            ));

        drawService.create(draw);

        Optional<Draw> drawOne = drawService.findOne(1L);

        drawOne.ifPresent(System.out::println);
    }


}
