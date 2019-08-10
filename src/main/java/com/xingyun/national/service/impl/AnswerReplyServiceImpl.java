package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.AnswerReply;
import com.xingyun.national.mapper.AnswerReplyMapper;
import com.xingyun.national.service.IAnswerReplyService;
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
public class AnswerReplyServiceImpl extends ServiceImpl<AnswerReplyMapper, AnswerReply> implements IAnswerReplyService {

    @Autowired
    private AnswerReplyMapper answerReplyMapper;

//    public List<AnswerReply> getAnswerReplys(){
//        return answerReplyMapper.findAll();
//    }

    @Override
    public PageInfo<AnswerReply> getAnswerReplys(int page, int limit){
        PageHelper.startPage(page,limit);
        List<AnswerReply> list=answerReplyMapper.findAll();
        PageInfo<AnswerReply> pageInfo= new PageInfo<AnswerReply>(list);
        return pageInfo;
    }

}
