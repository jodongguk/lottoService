package com.donggoos.lotto.draw.service;

import com.donggoos.lotto.core.EntityFactory;
import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.domain.repository.DrawRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawService {

    @Autowired
    private DrawRepository drawRepository;

    public Draw create(EntityFactory<Draw> factory) {
        return drawRepository.save(factory.create());
    }

    public Optional<Draw> findOne(Long id) {
        return drawRepository.findById(id);
    }
}
