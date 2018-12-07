package com.donggoos.lotto.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LottoResult {

    @JsonUnwrapped
    @EmbeddedId
    private LottoResultId id;

    // 등위별 총 당첨금액
    @Column(name = "SELLING_PRICE_BY_RANK")
    private String sellingPriceByRank;

    // 각 당첨자 별 당첨금액
    @Column(name = "WINNING_PRICE_BY_RANK")
    private String winningPriceByRank;

    // 당첨자 수
    @Column(name = "WINNING_CNT")
    private String winningCnt;


    @ToString
    @Getter
    @Setter
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    static class LottoResultId implements Serializable {

        @Column(name = "DRAW_NO")
        private Long drawNo;

        // 랭킹 (FIRST : 1등, SECOND : 2등 , THIRD : 3등 , FOURTH : 4등, FIFTH : 5등 )
        @Column(name = "RANK")
        private String rank;
    }
}

