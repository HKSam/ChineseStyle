package com.xingyun.national.mapper;

import com.xingyun.national.entity.AnswerZan;
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
public interface AnswerZanMapper extends BaseMapper<AnswerZan> {

    @Select("select * from answer_zan")
    public List<AnswerZan> findAll();
}
