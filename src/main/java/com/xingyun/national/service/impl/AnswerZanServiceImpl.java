package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.AnswerZan;
import com.xingyun.national.entity.UserFeedback;
import com.xingyun.national.mapper.AnswerZanMapper;
import com.xingyun.national.service.IAnswerZanService;
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
public class AnswerZanServiceImpl extends ServiceImpl<AnswerZanMapper, AnswerZan> implements IAnswerZanService {

    @Autowired
    private AnswerZanMapper answerZanMapper;

//    public List<AnswerZan> getAnswerZans(){
//        return answerZanMapper.findAll();
//    }

    @Override
    public PageInfo<AnswerZan> getAnswerZans(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<AnswerZan> list=answerZanMapper.findAll();
        PageInfo<AnswerZan> pageInfo= new PageInfo<AnswerZan>(list);
        return pageInfo;
    }

}
