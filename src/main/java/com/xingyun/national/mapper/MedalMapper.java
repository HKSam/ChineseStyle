package com.xingyun.national.mapper;

import com.xingyun.national.entity.Medal;
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
public interface MedalMapper extends BaseMapper<Medal> {

    @Select("select * from medal")
    public List<Medal> getMedals();

    @Select("select * from medal where id=#{id}")
    public Medal getMedalById(long id);
}
