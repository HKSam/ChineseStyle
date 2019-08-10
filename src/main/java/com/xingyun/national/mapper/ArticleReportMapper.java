package com.xingyun.national.mapper;

import com.xingyun.national.entity.ArticleDetails;
import com.xingyun.national.entity.ArticleReport;
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
public interface ArticleReportMapper extends BaseMapper<ArticleReport> {

    @Select("select id as id," +
            "article_id as article_id," +
            "report_uid as report_uid," +
            "reported_uid as reported_uid," +
            "report_type as report_type," +
            "report_content as report_content," +
            "status as status," +
            "create_time as create_time," +
            "update_time as update_time from article_report")
    public List<ArticleReport> findAll();

    @Select("select * from article_report where id=#{id}")
    public ArticleReport getAllById(long id);
}
