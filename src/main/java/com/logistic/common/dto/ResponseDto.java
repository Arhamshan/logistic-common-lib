package com.logistic.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private LocalDateTime timestamp;

    private String requestId;

    private Integer responseCode;

    private String responseMessage;

    private T data;

}
