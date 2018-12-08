package com.donggoos.lotto.draw.domain;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Draw {

    @Id
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

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="drawNo")
    private List<LottoResult> lottoResult = new ArrayList<>();

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="drawNo")
    private List<WinningPlace> winningPlace = new ArrayList<>();

    public Draw(Long drawNo, String drawDate, String drawDateYn, int num1, int num2, int num3, int num4, int num5,
        int num6, int bonusNum, Long totalSellingPrice, List<LottoResult> lottoResult, List<WinningPlace> winningPlace) {
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
        this.winningPlace = winningPlace;
    }
}
