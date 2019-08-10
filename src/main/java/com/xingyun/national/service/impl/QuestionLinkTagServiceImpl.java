package com.xingyun.national.service.impl;

import com.xingyun.national.entity.QuestionLinkTag;
import com.xingyun.national.mapper.QuestionLinkTagMapper;
import com.xingyun.national.service.IQuestionLinkTagService;
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
public class QuestionLinkTagServiceImpl extends ServiceImpl<QuestionLinkTagMapper, QuestionLinkTag> implements IQuestionLinkTagService {

    @Autowired
    private QuestionLinkTagMapper questionLinkTagMapper;

    public List<QuestionLinkTag> getQuestionLinkTags(){
        return questionLinkTagMapper.findAll();
    }
}
