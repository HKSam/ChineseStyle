package com.xingyun.national.mapper;

import com.xingyun.national.entity.ArticleComment;
import com.xingyun.national.entity.ArticleDetails;
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
public interface ArticleDetailsMapper extends BaseMapper<ArticleDetails> {

    @Select("select id as id," +
            "article_id as article_id," +
            "image as image," +
            "content as content," +
            "is_delete as is_delete from article_details")
    public List<ArticleDetails> findAll();

    @Select("select * from article_details where id=#{id}")
    public ArticleDetails getAllById(long id);
}
