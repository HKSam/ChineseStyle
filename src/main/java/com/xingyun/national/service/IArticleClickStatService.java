package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleClickStat;
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
public interface IArticleClickStatService extends IService<ArticleClickStat> {

    public List<ArticleClickStat> getArticlesClickStat();

    public PageInfo<ArticleClickStat> findArticleClickStat(int page, int limit);
}
