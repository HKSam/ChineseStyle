package com.xingyun.national.mapper;

import com.xingyun.national.entity.WindDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface WindDetailsMapper extends BaseMapper<WindDetails> {

    @Select("select * from national_wind_details")
    public List<WindDetails> findAll();

    @Update("update national_wind_details set national_id=#{nationalId},image=#{image},content=#{content} where id=#{id}")
    public void updateWind(WindDetails windDetails);

    @Select("select * from national_wind_details where id=#{id}")
    public WindDetails getWindDetailsById(long id);
}
