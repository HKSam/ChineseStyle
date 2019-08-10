package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.QuestionAnswer;
import com.xingyun.national.mapper.QuestionAnswerMapper;
import com.xingyun.national.service.IQuestionAnswerService;
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
public class QuestionAnswerServiceImpl extends ServiceImpl<QuestionAnswerMapper, QuestionAnswer> implements IQuestionAnswerService {

    @Autowired
    private QuestionAnswerMapper questionAnswerMapper;

//    public List<QuestionAnswer> getQuestionAnswers(){
//        return questionAnswerMapper.findAll();
//    }

    @Override
    public PageInfo<QuestionAnswer> getQuestionAnswers(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<QuestionAnswer> list= questionAnswerMapper.findAll();
        PageInfo<QuestionAnswer> pageInfo= new PageInfo<QuestionAnswer>(list);
        return pageInfo;
    }


}
