package com.xingyun.national.mapper;

import com.xingyun.national.entity.AdminUser;
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
 * @since 2019-07-07
 */
@Component
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    @Select("select password from admin_user where name=#{name}")
    public AdminUser getUserByName(String name);

    @Select("select * from admin_user")
    public List<AdminUser> getAll();


}
