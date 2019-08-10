package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleComment;
import com.xingyun.national.mapper.ArticleCommentMapper;
import com.xingyun.national.service.IArticleCommentService;
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
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment> implements IArticleCommentService {

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    public List<ArticleComment> getArticleComments(){
        return this.articleCommentMapper.findAll();
    }

    @Override
    public PageInfo<ArticleComment> findAC(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ArticleComment> list=articleCommentMapper.findAll();
        PageInfo<ArticleComment> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ArticleComment findAcById(long id) {
        return this.articleCommentMapper.getAcById(id);
    }
}
