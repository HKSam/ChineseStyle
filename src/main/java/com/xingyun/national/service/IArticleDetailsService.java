package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleDetails;
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
public interface IArticleDetailsService extends IService<ArticleDetails> {

    public List<ArticleDetails> getArticleDetails();

    public PageInfo<ArticleDetails> findAticleDetails(int page,int limit);

    public ArticleDetails getArticleDetailById(long id);
}
