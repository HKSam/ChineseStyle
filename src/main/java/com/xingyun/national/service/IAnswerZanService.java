package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.AnswerReply;
import com.xingyun.national.entity.AnswerZan;
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
public interface IAnswerZanService extends IService<AnswerZan> {

//    public List<AnswerZan> getAnswerZans();

    PageInfo<AnswerZan> getAnswerZans(int page, int limit);

}
