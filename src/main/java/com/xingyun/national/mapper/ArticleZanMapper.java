package com.xingyun.national.mapper;

import com.xingyun.national.entity.ArticleDetails;
import com.xingyun.national.entity.ArticleZan;
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
public interface ArticleZanMapper extends BaseMapper<ArticleZan> {

    @Select("select id as id," +
            "article_id as article_id," +
            "count as count from article_zan")
    public List<ArticleZan> findAll();
}
