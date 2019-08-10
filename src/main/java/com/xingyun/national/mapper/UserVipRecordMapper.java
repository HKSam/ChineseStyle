package com.xingyun.national.mapper;

import com.xingyun.national.entity.UserVipRecord;
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
public interface UserVipRecordMapper extends BaseMapper<UserVipRecord> {

    @Select("select * from user_vip_record")
    public List<UserVipRecord> findVipRecord();
}
