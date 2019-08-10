package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleZan;
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
public interface IArticleZanService extends IService<ArticleZan> {

    public List<ArticleZan> getArticleZans();

    public PageInfo<ArticleZan> findArticleZan(int page,int limit);
 }
