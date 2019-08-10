package com.xingyun.national.dto;

import java.util.Date;

public class Vipdto {

    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 会员卡id
     */
    private String vipKindName;

    /**
     * 购买时间
     */
    private Date startTime;

    /**
     * 截止时间
     */
    private Date endTime;

    /**
     * 是否自动连续购买
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVipKindName() {
        return vipKindName;
    }

    public void setVipKindName(String vipKindName) {
        this.vipKindName = vipKindName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
