package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.CommentZan;
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
public interface ICommentZanService extends IService<CommentZan> {

    public List<CommentZan> getCommentZans();

    public PageInfo<CommentZan> findCommentZan(int page,int limit);

}
