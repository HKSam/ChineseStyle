package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.QuestionZan;
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
public interface IQuestionZanService extends IService<QuestionZan> {

//    public List<QuestionZan> getQuestionZans();

    PageInfo<QuestionZan> getQuestionZans(int page, int limit);

}
