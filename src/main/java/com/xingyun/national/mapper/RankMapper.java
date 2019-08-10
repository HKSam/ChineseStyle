package com.xingyun.national.mapper;

import com.xingyun.national.entity.Rank;
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
public interface RankMapper extends BaseMapper<Rank> {

    @Select("select * from rank")
    public List<Rank> findAll();

    @Select("select * from rank where id=#{id}")
    public Rank getRankById(long id);

    @Update("update rank set " +
            "rank=#{rank}," +
            "rank_name=#{rankName} where id=#{id}")
    public void updateAll(Rank rank);
}
