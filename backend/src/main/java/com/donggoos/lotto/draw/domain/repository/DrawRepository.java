package com.donggoos.lotto.draw.domain.repository;

import com.donggoos.lotto.draw.domain.Draw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawRepository extends JpaRepository<Draw, Long> {

}
