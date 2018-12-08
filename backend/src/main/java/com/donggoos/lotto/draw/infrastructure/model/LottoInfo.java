package com.donggoos.lotto.draw.infrastructure.model;

import com.donggoos.lotto.core.EntityFactory;
import com.donggoos.lotto.draw.domain.Draw;
import com.donggoos.lotto.draw.domain.LottoResult;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LottoInfo implements EntityFactory<Draw> {
    private Long drawNo;        // 회차번호
    private String drawDate;       // 추첨일자
    // Y : 추첨날짜와 yyyyMMdd 파라미터로 전달된 값이 같을경우
    // N : drawNo 파라미터가 전달되었거나 추첨날짜와 yyyyMMdd 파라미터로 전달된 값이 다를경우
    private String drawDateYn;
    private int num1;       // 1번째 추첨번호
    private int num2;       // 2번째 추첨번호
    private int num3;       //3번째 추첨번호
    private int num4;       // 4번째 추첨번호
    private int num5;       //5번째 추첨번호
    private int num6;       // 6번째 추첨번호
    private int bonusNum;   //추첨번호
    private Long totalSellingPrice; // 총 판매금액.
    private List<LottoResult> lottoResult;

    public LottoInfo(Long drawNo, String drawDate, String drawDateYn, int num1, int num2, int num3, int num4, int num5,
        int num6, int bonusNum, Long totalSellingPrice,
        List<LottoResult> lottoResult) {
        this.drawNo = drawNo;
        this.drawDate = drawDate;
        this.drawDateYn = drawDateYn;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
        this.bonusNum = bonusNum;
        this.totalSellingPrice = totalSellingPrice;
        this.lottoResult = lottoResult;
    }

    public Draw create() {
        return new Draw(drawNo, drawDate, drawDateYn, num1, num2, num3, num4, num5, num6, bonusNum, totalSellingPrice, lottoResult, new ArrayList<>());
    }
}
