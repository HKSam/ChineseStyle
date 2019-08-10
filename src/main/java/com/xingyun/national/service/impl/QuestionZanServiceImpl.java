package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.QuestionZan;
import com.xingyun.national.mapper.QuestionZanMapper;
import com.xingyun.national.service.IQuestionZanService;
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
public class QuestionZanServiceImpl extends ServiceImpl<QuestionZanMapper, QuestionZan> implements IQuestionZanService {

    @Autowired
    private QuestionZanMapper questionZanMapper;

//    public List<QuestionZan> getQuestionZans(){
//        return questionZanMapper.findAll();
//    }

    @Override
    public PageInfo<QuestionZan> getQuestionZans(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<QuestionZan> list= questionZanMapper.findAll();
        PageInfo<QuestionZan> pageInfo= new PageInfo<QuestionZan>(list);
        return pageInfo;
    }


}
