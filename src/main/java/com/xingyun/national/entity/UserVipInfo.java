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
* @since 2019-07-17
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class UserVipInfo implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

            /**
            * 用户id
            */
    private Long userId;

            /**
            * 会员卡id
            */
    private Integer kindVid;

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


}
