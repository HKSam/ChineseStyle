package com.xingyun.national.mapper;

import com.xingyun.national.entity.Question;
import com.xingyun.national.entity.QuestionAnswer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface QuestionAnswerMapper extends BaseMapper<QuestionAnswer> {

    @Select("select * from question_answer")
    public List<QuestionAnswer> findAll();
}
