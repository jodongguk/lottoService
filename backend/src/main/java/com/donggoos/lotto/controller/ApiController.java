package com.donggoos.lotto.controller;

import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.domain.repository.DrawRepository;
import com.donggoos.lotto.draw.service.DrawWithApiService;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/api/v1")
@RestController
public class ApiController {

    @Autowired
    private DrawWithApiService drawWithApiService;

    @Autowired
    private DrawRepository drawRepository;

    @GetMapping(value = "/draw")
    public List<Draw> getDrawList() {
        return drawRepository.findAll();
    }

    @GetMapping(value = "/draw/{id}")
    public Draw findOne(@PathVariable Long id) {
        return drawWithApiService.findOne(id);
    }

    @ExceptionHandler
    public String lottoNotFound(EntityNotFoundException e) {
        return "회차에 해당하는 로또 당첨번호 정보가 없습니다.";
    }

}
