package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.QuestionAnswer;
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
public interface IQuestionAnswerService extends IService<QuestionAnswer> {

//    public List<QuestionAnswer> getQuestionAnswers();

    PageInfo<QuestionAnswer> getQuestionAnswers(int page, int limit);

}
