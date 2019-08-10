package com.xingyun.national.mapper;

import com.xingyun.national.entity.Wind;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface WindMapper extends BaseMapper<Wind> {

    @Select("select * from national_wind")
    public List<Wind> findAll();

    @Update("update national_wind set cover=#{cover},create_time=#{createTime}," +
            "update_time=now(),is_delete=#{isDelete} where id=#{id}")
    public void updateWind(Wind wind);

    @Select("select * from national_wind where id=#{id}")
    public Wind getWindById(long id);

    @Insert("insert into national_wind(cover,create_time,update_time,is_delete) values(#{cover},now(),now(),0)")
    public void insertWind(Wind wind);

    @Select("select count(*) as counts from national_wind")
    public long countAll();
}
