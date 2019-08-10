package com.xingyun.national.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResultGenerator<T> implements Serializable {

    private int status;

    private String msg;

    private T data;

    private ResultGenerator(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResultGenerator(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResultCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ResultGenerator<T> createBySuccess(T data) {
        return new ResultGenerator<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), data);
    }

    public static <T> ResultGenerator<T> createBySuccess(String msg, T data) {
        return new ResultGenerator<T>(ResultCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> ResultGenerator<T> createByError() {
        return new ResultGenerator<T>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getDesc());
    }

}
