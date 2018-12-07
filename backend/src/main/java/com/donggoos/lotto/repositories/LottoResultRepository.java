package com.donggoos.lotto.repositories;

import com.donggoos.lotto.model.LottoResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoResultRepository extends JpaRepository<LottoResult, String> {
}
