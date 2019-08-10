package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Question;
import com.xingyun.national.mapper.QuestionMapper;
import com.xingyun.national.service.IQuestionService;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

//    public List<Question> getQuestions(){
//        return this.questionMapper.findAll();
//    }


    @Override
    public PageInfo<Question> findQueList(int page, int limit){
        PageHelper.startPage(page,limit);
        List<Question> list=questionMapper.findAll();
        PageInfo<Question> queListInfo= new PageInfo<Question>(list);
        return queListInfo;
    }
}
