package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleClickStat;
import com.xingyun.national.entity.ArticleComment;
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
public interface IArticleCommentService extends IService<ArticleComment> {
    public List<ArticleComment> getArticleComments();

    public PageInfo<ArticleComment> findAC(int page,int limit);

    public ArticleComment findAcById(long id);
}
