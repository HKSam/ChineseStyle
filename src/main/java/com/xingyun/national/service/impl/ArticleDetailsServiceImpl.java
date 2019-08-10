package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleDetails;
import com.xingyun.national.mapper.ArticleDetailsMapper;
import com.xingyun.national.service.IArticleDetailsService;
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
public class ArticleDetailsServiceImpl extends ServiceImpl<ArticleDetailsMapper, ArticleDetails> implements IArticleDetailsService {

    @Autowired
    private ArticleDetailsMapper articleDetailsMapper;

    public List<ArticleDetails> getArticleDetails(){
        return articleDetailsMapper.findAll();
    }

    @Override
    public PageInfo<ArticleDetails> findAticleDetails(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ArticleDetails> list=articleDetailsMapper.findAll();
        PageInfo<ArticleDetails> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ArticleDetails getArticleDetailById(long id) {
        return this.articleDetailsMapper.getAllById(id);
    }
}
