package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleReport;
import com.xingyun.national.mapper.ArticleReportMapper;
import com.xingyun.national.service.IArticleReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Service
public class ArticleReportServiceImpl extends ServiceImpl<ArticleReportMapper, ArticleReport> implements IArticleReportService {

    @Autowired
    ArticleReportMapper articleReportMapper;

    public List<ArticleReport> getArticleReports(){
        return articleReportMapper.findAll();
    }

    @Override
    public PageInfo<ArticleReport> findArticleReport(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ArticleReport> list=articleReportMapper.findAll();
        PageInfo<ArticleReport> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ArticleReport getReportById(long id) {
        return this.articleReportMapper.getAllById(id);
    }
}
