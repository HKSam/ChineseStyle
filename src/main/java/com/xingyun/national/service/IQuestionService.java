package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.CommentZan;
import com.xingyun.national.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xingyun.national.entity.UserFeedback;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
public interface IQuestionService extends IService<Question> {

//    public List<Question> getQuestions();

    PageInfo<Question> findQueList(int page , int limit);

}
