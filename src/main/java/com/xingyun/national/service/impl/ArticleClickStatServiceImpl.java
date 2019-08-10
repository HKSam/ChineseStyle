package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ArticleClickStat;
import com.xingyun.national.mapper.ArticleClickStatMapper;
import com.xingyun.national.service.IArticleClickStatService;
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
public class ArticleClickStatServiceImpl extends ServiceImpl<ArticleClickStatMapper, ArticleClickStat> implements IArticleClickStatService {

    @Autowired
    private ArticleClickStatMapper articleClickStatMapper;

    public List<ArticleClickStat> getArticlesClickStat(){
        return articleClickStatMapper.findAll();
    }

    @Override
    public PageInfo<ArticleClickStat> findArticleClickStat(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<ArticleClickStat> list=articleClickStatMapper.findAll();
        PageInfo<ArticleClickStat> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
