package com.xingyun.national.mapper;

import com.xingyun.national.entity.Activity;
import com.xingyun.national.entity.ArticleClickStat;
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
public interface ArticleClickStatMapper extends BaseMapper<ArticleClickStat> {


    @Select("select id as id," +
            "article_id as article_id," +
            "click_rate as click_rate from article_click_stat")
    public List<ArticleClickStat> findAll();
}
