package com.donggoos.lotto.service;

import com.donggoos.lotto.model.Draw;
import com.donggoos.lotto.repositories.DrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DrawService {

    @Autowired
    private ApiService apiService;

    @Autowired
    private DrawRepository drawRepository;

    public Draw getDrawOne(Long id) throws IOException {

        if(!drawRepository.existsById(id)) {
            apiService.getApiDrawOne(id);
        }

        return drawRepository.findById(id).get();
    }
}
