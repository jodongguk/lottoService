package com.donggoos.lotto.controller;

import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.domain.repository.DrawRepository;
import com.donggoos.lotto.draw.service.DrawWithApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    public Draw getDrawOne(@PathVariable Long id) {
        return drawWithApiService.findOne(id);
    }

}
