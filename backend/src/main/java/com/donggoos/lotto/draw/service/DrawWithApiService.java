package com.donggoos.lotto.draw.service;

import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.infrastructure.ApiService;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DrawWithApiService {

    private DrawService drawService;
    private ApiService apiService;

    @Transactional
    public Draw findOne(Long id) {
        return drawService.findOne(id).orElseGet(() -> getLottoInfoByApi(id));
    }

    private Draw getLottoInfoByApi(Long id) {
        return apiService.lotto(id)
            .map(drawService::create)
            .orElseThrow(EntityNotFoundException::new);
    }

    public DrawWithApiService(DrawService drawService, ApiService apiService) {
        this.drawService = drawService;
        this.apiService = apiService;
    }
}
