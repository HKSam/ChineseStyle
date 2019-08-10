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
    public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 用户信息表id
            */
    private Long userId;

            /**
            * 文章标题
            */
    private String articleTitle;

            /**
            * 文章封面
            */
    private String articleCover;

            /**
            * 文章创建时间
            */
    private Date createTime;

            /**
            * 文章修改时间
            */
    private Date updateTime;

    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
