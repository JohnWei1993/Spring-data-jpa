package com.bizfocus.consulservice.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @program: consul-service
 * @description:
 * @author: John.Wei
 * @create: 2018-11-30 16:32
 **/
@Setter
@Getter
@AllArgsConstructor
@Builder
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    private boolean result;

    @Builder.Default
    @JsonSerialize(using = ToStringSerializer.class)
    private long timestamp = System.currentTimeMillis();

    public ResponseData() {
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseData(T data, boolean result) {
        this.timestamp = System.currentTimeMillis();
        this.data = data;
        this.result = result;
    }

    public ResponseData(String message, boolean result) {
        this.timestamp = System.currentTimeMillis();
        this.result = result;
        this.message = message;
    }
}
