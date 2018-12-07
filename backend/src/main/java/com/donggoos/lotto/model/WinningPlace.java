package com.donggoos.lotto.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class WinningPlace {

    @Id
    @GeneratedValue(strategy = GenerationType. AUTO)
    @Column(name = "SEQ")
    private Long seq;

    @Column(name = "DRAW_NO")
    private Long drawNo;

    // 상호명
    @Column(name = "SHOP_NAME")
    private String shopName;

    // 상호주소
    @Column(name = "ADDRESS")
    private String  address;

    // 위도
    @Column(name = "LAT")
    private String lat;

    // 경도
    @Column(name = "LNG")
    private String lng;

    // 게임방법 ( AUTO("자동"), SEMI_AUTO("반자동"), MANUAL("수동"), UNKNOWN("알수없음")
    @Column(name = "GAME_TYPE")
    private String gameType;
}
