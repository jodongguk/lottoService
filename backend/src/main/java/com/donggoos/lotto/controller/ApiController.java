package com.donggoos.lotto.controller;

import com.donggoos.lotto.model.Draw;
import com.donggoos.lotto.repositories.DrawRepository;
import com.donggoos.lotto.service.ApiService;
import com.donggoos.lotto.service.DrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RequestMapping(value = "/api/v1")
@RestController
public class ApiController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DrawService drawService;

    @Autowired
    private DrawRepository drawRepository;

    @GetMapping(value = "/draw")
    public List<Draw> getDrawList() {
        return drawRepository.findAll();
    }

    @GetMapping(value = "/draw/{id}")
    public Draw getDrawOne(@PathVariable(required = true, name = "id") Long id) throws IOException {
        return drawService.getDrawOne(id);
    }

}
