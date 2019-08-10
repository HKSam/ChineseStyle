package com.xingyun.national.mapper;

import com.xingyun.national.entity.UserCoin;
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
public interface UserCoinMapper extends BaseMapper<UserCoin> {

    @Select("select * from user_coin")
    public List<UserCoin> findAll();
}
