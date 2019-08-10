package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.QuestionClick;
import com.xingyun.national.mapper.QuestionClickMapper;
import com.xingyun.national.service.IQuestionClickService;
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
public class QuestionClickServiceImpl extends ServiceImpl<QuestionClickMapper, QuestionClick> implements IQuestionClickService {

    @Autowired
    private QuestionClickMapper questionClickMapper;

//    public List<QuestionClick> getQuestionClicks(){
//        return questionClickMapper.findAll();
//    }


    @Override
    public PageInfo<QuestionClick> getQuestionClicks(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<QuestionClick> list= questionClickMapper.findAll();
        PageInfo<QuestionClick> pageInfo= new PageInfo<QuestionClick>(list);
        return pageInfo;
    }

}
