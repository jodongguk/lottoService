package com.donggoos.lotto.draw.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WinningPlace {

    @Id
    @GeneratedValue(strategy = GenerationType. AUTO)
    private Long id;
    private String shopName;    // 상호명
    private String  address;    // 상호주소
    private String lat;         // 위도
    private String lng;         // 경도
    private String gameType;    // 게임방법 ( AUTO("자동"), SEMI_AUTO("반자동"), MANUAL("수동"), UNKNOWN("알수없음")

    public WinningPlace(String shopName, String address, String lat, String lng, String gameType) {
        this.shopName = shopName;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.gameType = gameType;
    }
}
