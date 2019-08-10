package com.xingyun.national.common;


public enum ResultCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(400,"ERROR");

    private final int code;
    private final String desc;


    ResultCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
