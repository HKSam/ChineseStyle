package com.xingyun.national.mapper;

import com.xingyun.national.entity.Activity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingyun.national.entity.User;
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
public interface ActivityMapper extends BaseMapper<Activity> {

    @Select("select id as id," +
            "activity_title as activity_title," +
            "activity_cover as activity_cover," +
            "start_time as start_time," +
            "end_time as end_time," +
            "DATE_FORMAT(create_time,'%Y-%m-%d %H:%i:%s') as create_time," +
            "update_time as update_time," +
            "is_delete as is_delete from activity")
    public List<Activity> findAll();

    @Select("select * from activity where id=#{id}")
    public Activity getActivityById(long id);

    @Insert("insert into activity(activity_title,activity_cover,start_time,end_time,create_time,update_time,is_delete) values(#{activityTitle},#{activityCover},#{startTime},#{endTime},now(),now(),0)")
    public void add(Activity activity);

    @Select("select count(*) as counts from activity")
    public long countAll();
}
