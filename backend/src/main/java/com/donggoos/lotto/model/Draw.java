package com.donggoos.lotto.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@JsonDeserialize(using = DrawDeserialize.class)
@NoArgsConstructor
@AllArgsConstructor
public class Draw {

    // 회차번호.
    @Id
    @Column(name = "DRAW_NO")
    private Long drawNo;

    // 추첨일자
    @Column(name = "DRAW_DATE")
    private String drawDate;

    // Y : 추첨날짜와 yyyyMMdd 파라미터로 전달된 값이 같을경우
    // N : drawNo 파라미터가 전달되었거나 추첨날짜와 yyyyMMdd 파라미터로 전달된 값이 다를경우
    @Column(name = "DRAW_DATE_YN")
    private String drawDateYn;

    // 1번째 추첨번호
    @Column(name = "NUM1")
    private int num1;

    // 2번째 추첨번호
    @Column(name = "NUM2")
    private int num2;

    //3번째 추첨번호
    @Column(name = "NUM3")
    private int num3;

    // 4번째 추첨번호
    @Column(name = "NUM4")
    private int num4;

    //5번째 추첨번호
    @Column(name = "NUM5")
    private int num5;

    // 6번째 추첨번호
    @Column(name = "NUM6")
    private int num6;

    //추첨번호
    @Column(name = "BONUS_NUM")
    private int bonusNum;

    // 총 판매금액.
    @Column(name = "TOTAL_SELLING_PRICE")
    private Long totalSellingPrice;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="DRAW_NO")
    private List<LottoResult> lottoResult;


    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="DRAW_NO")
    private List<WinningPlace> winningPlace;

}
