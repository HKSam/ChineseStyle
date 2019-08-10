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
    public class ArticleComment implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 用户id
            */
    private Long userId;

            /**
            * 文章id
            */
    private Long articleId;

            /**
            * 评论类容
            */
    private String comment;

            /**
            * 是否已删除，0：未删除，1：已删除
            */
    private Integer isDelete;

            /**
            * 创建时间
            */
    private Date createTime;

            /**
            * 最后一次更新时间
            */
    private Date updateTime;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
