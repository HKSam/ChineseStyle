package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleDetails;
import com.xingyun.national.entity.ArticleReport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
public interface IArticleReportService extends IService<ArticleReport> {

    public List<ArticleReport> getArticleReports();

    public PageInfo<ArticleReport> findArticleReport(int page,int limit);

    public ArticleReport getReportById(long id);
}
