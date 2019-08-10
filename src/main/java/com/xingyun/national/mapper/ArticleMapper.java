package com.xingyun.national.mapper;

import com.xingyun.national.entity.ActivityDetails;
import com.xingyun.national.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select id as id," +
            "user_id as user_id," +
            "article_title as article_title," +
            "article_cover as article_cover," +
            "create_time as create_time," +
            "update_time as update_time," +
            "is_delete as is_delete from article")
    public List<Article> findAll();

    @Select("select * from article where id=#{id}")
    public Article getArticleById(long id);

    @Select("select count(*) as counts from article")
    public long countACAll();

    @Select("SELECT * FROM article WHERE article_title LIKE CONCAT('%','#{articleTitle}','%')")
    public List<Article> findAllByTitle(@Param("articleTitle") String articleTitle);
}
