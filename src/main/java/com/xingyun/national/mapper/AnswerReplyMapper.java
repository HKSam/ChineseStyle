package com.xingyun.national.mapper;

import com.xingyun.national.entity.AnswerReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingyun.national.entity.Question;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
@Component
public interface AnswerReplyMapper extends BaseMapper<AnswerReply> {

    @Select("select * from answer_reply")
    public List<AnswerReply> findAll();
}
