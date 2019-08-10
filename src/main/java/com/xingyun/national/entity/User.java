package com.xingyun.national.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.Date;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author CYS
* @since 2019-07-09
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 微信的用户openid
            */
    private String openId;

            /**
            * 等级id
            */
    private Long rankId;

            /**
            * 勋章id
            */
    private Long medalId;

            /**
            * 用户昵称
            */
    private String nickName;

            /**
            * 头像地址
            */
    private String avatarUrl;

            /**
            * 用户个性签名
            */
    private String signature;

            /**
            * 性别：0未知，1 男， 2 女
            */
    private Integer gender;

    private String province;

            /**
            * 城市名
            */
    private String city;

            /**
            * 国家
            */
    private String country;

    private String phone;

            /**
            * 用户状态，禁用0，正常1
            */
    private Integer status;

            /**
            * 用户角色：
            */
    private Integer role;

    private Date createTime;

    private Date updateTime;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
