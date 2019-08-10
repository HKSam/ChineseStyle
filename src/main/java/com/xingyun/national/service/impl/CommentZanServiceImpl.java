package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.CommentZan;
import com.xingyun.national.mapper.CommentZanMapper;
import com.xingyun.national.service.ICommentZanService;
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
 * @since 2019-07-10
 */
@Service
public class CommentZanServiceImpl extends ServiceImpl<CommentZanMapper, CommentZan> implements ICommentZanService {

    @Autowired
    private CommentZanMapper commentZanMapper;

    public List<CommentZan> getCommentZans(){
        return commentZanMapper.findAll();
    }

    @Override
    public PageInfo<CommentZan> findCommentZan(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<CommentZan> list=commentZanMapper.findAll();
        PageInfo<CommentZan> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
