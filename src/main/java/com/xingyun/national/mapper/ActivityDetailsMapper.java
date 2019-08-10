package com.xingyun.national.mapper;

import com.xingyun.national.entity.Activity;
import com.xingyun.national.entity.ActivityDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Component
public interface ActivityDetailsMapper extends BaseMapper<ActivityDetails> {

    @Select("select id as id," +
            "activity_id as activity_id," +
            "image as image," +
            "content as content," +
            "is_delete as is_delete from activity_details")
    public List<ActivityDetails> findAll();

    @Insert("insert into activity_details(activity_id,image,content,is_delete) values(#{activityId},#{image},#{content},0)")
    public void add(ActivityDetails activityDetails);

    @Select("select * from activity_details where id=#{id}")
    public ActivityDetails getActivityDetailsById(long id);
}
