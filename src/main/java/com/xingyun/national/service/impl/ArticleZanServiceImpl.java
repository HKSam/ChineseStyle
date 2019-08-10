package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleZan;
import com.xingyun.national.mapper.ArticleZanMapper;
import com.xingyun.national.service.IArticleZanService;
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
public class ArticleZanServiceImpl extends ServiceImpl<ArticleZanMapper, ArticleZan> implements IArticleZanService {


    @Autowired
    private ArticleZanMapper articleZanMapper;

    public List<ArticleZan> getArticleZans(){
        return this.articleZanMapper.findAll();
    }

    @Override
    public PageInfo<ArticleZan> findArticleZan(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ArticleZan> list=articleZanMapper.findAll();
        PageInfo<ArticleZan> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
