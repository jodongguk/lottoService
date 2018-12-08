package com.donggoos.lotto.draw.service;

import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.infrastructure.ApiService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

@Service
public class DrawWithApiService {

    private DrawService drawService;
    private ApiService apiService;

    public DrawWithApiService(DrawService drawService, ApiService apiService) {
        this.drawService = drawService;
        this.apiService = apiService;
    }

    @Transactional
    public Draw findOne(Long id) {
        return drawService.findOne(id).orElseGet(() -> getLottoInfoByApi(id));
    }

    private Draw getLottoInfoByApi(Long id) {
        return apiService.lotto(id)
                .map(drawService::create)
                .orElseThrow(EntityExistsException::new);
    }
}
