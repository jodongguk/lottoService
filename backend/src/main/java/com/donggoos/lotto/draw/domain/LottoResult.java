package com.donggoos.lotto.draw.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LottoResult {

    @Id
    @GeneratedValue
    private Long id;
    private String sellingPriceByRank;    // 등위별 총 당첨금액
    private String winningPriceByRank;    // 각 당첨자 별 당첨금액
    private String winningCnt;    // 당첨자 수

    public LottoResult(String sellingPriceByRank, String winningPriceByRank, String winningCnt) {
        this.sellingPriceByRank = sellingPriceByRank;
        this.winningPriceByRank = winningPriceByRank;
        this.winningCnt = winningCnt;
    }
}

