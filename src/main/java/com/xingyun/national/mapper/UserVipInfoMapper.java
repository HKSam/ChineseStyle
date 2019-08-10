package com.xingyun.national.mapper;

import com.xingyun.national.dto.Vipdto;
import com.xingyun.national.entity.UserVipInfo;
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
 * @since 2019-07-17
 */
@Component
public interface UserVipInfoMapper extends BaseMapper<UserVipInfo> {

    @Select("select * from user_vip_info")
    public List<UserVipInfo> findAll();

    public List<Vipdto> findVip();

    @Select("select count(*) from user_vip_info")
    public long countAll();
}
