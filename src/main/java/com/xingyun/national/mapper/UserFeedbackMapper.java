package com.xingyun.national.mapper;

import com.xingyun.national.entity.UserFeedback;
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
public interface UserFeedbackMapper extends BaseMapper<UserFeedback> {

    @Select("select * from user_feedback")
    public List<UserFeedback> findAll();

    @Select("select * from user_feedback where id=#{id}")
    public UserFeedback getById(long id);
}
