package com.donggoos.lotto.draw.infrastructure.model;

import lombok.Data;

@Data
public class ApiResponse {

    private String resultCode;
    private String statusCode;
    private LottoInfo body;
}
