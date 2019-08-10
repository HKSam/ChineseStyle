package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.CommentReply;
import com.xingyun.national.mapper.CommentReplyMapper;
import com.xingyun.national.service.ICommentReplyService;
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
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyMapper, CommentReply> implements ICommentReplyService {


    @Autowired
    private CommentReplyMapper commentReplyMapper;

    public List<CommentReply> getCommentReplys(){
        return commentReplyMapper.findAll();
    }

    @Override
    public CommentReply getReplyById(long id) {
        return this.commentReplyMapper.findAllById(id);
    }

    @Override
    public PageInfo<CommentReply> findReply(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<CommentReply> list=commentReplyMapper.findAll();
        PageInfo<CommentReply> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
