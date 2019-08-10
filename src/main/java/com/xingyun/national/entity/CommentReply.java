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
* @since 2019-07-10
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class CommentReply implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 回复用户id
            */
    private Long userId;

            /**
            * 评论表id
            */
    private Long commentId;

            /**
            * 帖子id
            */
    private Long articleId;

            /**
            * 回复内容
            */
    private String content;

            /**
            * 是否删除，0：未删除，1：已删除
            */
    private Integer isDelete;

            /**
            * 创建时间
            */
    private Date createTime;

            /**
            * 最后一次修改时间
            */
    private Date updateTime;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
