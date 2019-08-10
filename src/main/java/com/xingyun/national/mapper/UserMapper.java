package com.xingyun.national.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingyun.national.dto.Userdto;
import com.xingyun.national.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT user.id," +
            "user.open_id," +
            "rank_name," +
            "medal_name," +
            "user.nick_name," +
            "user.avatar_url," +
            "user.signature," +
            "user.gender," +
            "user.province," +
            "user.city," +
            "user.country," +
            "user.phone," +
            "user.status," +
            "user.role," +
            "user.create_time,user.update_time FROM user INNER JOIN rank on user.rank_id=rank.rank INNER JOIN medal on user.medal_id=medal.medal")
    public List<User> findAll();

    public List<Userdto> findAllUser();

    @Delete("delete from user where id=#{id}")
    public void delete(long id);

    @Select("select * from user where id=#{id}")
    public User getUserById(long id);

    @Update("update user set open_id=#{openId}," +
            "rank_id=#{rankId}," +
            "medal_id=#{medalId}," +
            "nick_name=#{nickName}," +
            "avatar_url=#{avatarUrl}," +
            "signature=#{signature}," +
            "gender=#{gender}," +
            "province=#{province}," +
            "city=#{city}," +
            "country=#{country}," +
            "phone=#{phone}," +
            "status=#{status}," +
            "role=#{role}," +
            "create_time=#{createTime}," +
            "update_time=#{updateTime} where id=#{id}")
    public void updateAll(User user);

    @Select("select count(*) as counts from user")
    public long countAll();

    @Select("SELECT * FROM user WHERE nick_name LIKE CONCAT('%','#{nickName}','%')")
    public List<User> findAllByName(String name);
}
