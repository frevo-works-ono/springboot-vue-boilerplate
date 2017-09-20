package jp.co.sample.domain.dto;

import lombok.Data;

@Data
public class Result {
    private int code;
    private Object data;
    private String message;
}
