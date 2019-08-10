package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Article;
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
public interface IArticleService extends IService<Article> {

    public List<Article> getArticles();

    public PageInfo<Article> findArticle(int page,int limit);

    public Article getArticleById(long id);

    public long countACAll();

    public PageInfo<Article> getArticleByTitle(String articleTitle,int page,int limit);
}
