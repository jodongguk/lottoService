package com.donggoos.lotto.draw.infrastructure.model;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String resultCode;
    private String statusCode;
    private T body;
}
