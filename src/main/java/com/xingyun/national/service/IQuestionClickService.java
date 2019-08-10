package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.QuestionClick;
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
public interface IQuestionClickService extends IService<QuestionClick> {

//    public List<QuestionClick> getQuestionClicks();

    PageInfo<QuestionClick> getQuestionClicks(int page, int limit);

}
