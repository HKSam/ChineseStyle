package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Activity;
import com.xingyun.national.entity.Article;
import com.xingyun.national.mapper.ArticleMapper;
import com.xingyun.national.service.IArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getArticles(){
        return articleMapper.findAll();
    }

    @Override
    public PageInfo<Article> findArticle(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<Article> list=articleMapper.findAll();
        PageInfo<Article> pageInfo= new PageInfo<Article>(list);
        return pageInfo;
    }

    @Override
    public Article getArticleById(long id) {
        return this.articleMapper.getArticleById(id);
    }

    @Override
    public long countACAll() {
        return this.articleMapper.countACAll();
    }

    @Override
    public PageInfo<Article> getArticleByTitle(String articleTitle,int page,int limit) {
        PageHelper.startPage(1,10);
        List<Article> list=articleMapper.findAllByTitle(articleTitle);
        PageInfo<Article> pageInfo=new PageInfo<Article>(list);
        return pageInfo;
    }
}
