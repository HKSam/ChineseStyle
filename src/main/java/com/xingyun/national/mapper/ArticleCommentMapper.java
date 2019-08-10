package com.xingyun.national.mapper;

import com.xingyun.national.entity.ArticleClickStat;
import com.xingyun.national.entity.ArticleComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Component
public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {

    @Select("select id as id," +
            "user_id as user_id," +
            "article_id as article_id," +
            "comment as comment," +
            "is_delete as is_delete," +
            "create_time as create_time," +
            "update_time as update_time from article_comment")
    public List<ArticleComment> findAll();

    @Select("select * from article_comment where id=#{id}")
    public ArticleComment getAcById(long id);
}
