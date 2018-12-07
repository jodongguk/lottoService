package com.donggoos.lotto.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;


@ToString
@Getter
@Setter
public class ApiRequest implements Serializable {

    // 응답코드
    private String resultCode;

    // HTTP 상태코드
    private String statusCode;

    private Map<String, Object> body;
}
