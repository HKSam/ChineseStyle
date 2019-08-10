package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.AnswerReply;
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
public interface IAnswerReplyService extends IService<AnswerReply> {

//    public List<AnswerReply> getAnswerReplys();

    PageInfo<AnswerReply> getAnswerReplys(int page, int limit);

}
