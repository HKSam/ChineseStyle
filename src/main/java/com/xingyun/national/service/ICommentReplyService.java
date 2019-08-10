package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.CommentReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
public interface ICommentReplyService extends IService<CommentReply> {

    public List<CommentReply> getCommentReplys();

    public PageInfo<CommentReply> findReply(int page,int limit);

    public CommentReply getReplyById(long id);
}
