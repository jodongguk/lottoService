package com.donggoos.lotto.draw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LottoResult {

    @Id
    @GeneratedValue
    private Long id;
    private String rank;
    private String sellingPriceByRank;  // 등위별 총 당첨금액
    private String winningPriceByRank;  // 각 당첨자 별 당첨금액
    private String winningCnt;          // 당첨자 수

    public LottoResult(String rank, String sellingPriceByRank, String winningPriceByRank,
        String winningCnt) {
        this.rank = rank;
        this.sellingPriceByRank = sellingPriceByRank;
        this.winningPriceByRank = winningPriceByRank;
        this.winningCnt = winningCnt;
    }
}

