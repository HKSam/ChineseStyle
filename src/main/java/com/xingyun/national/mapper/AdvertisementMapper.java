package com.xingyun.national.mapper;

import com.xingyun.national.entity.Advertisement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingyun.national.entity.User;
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
 * @since 2019-07-09
 */
@Component
public interface AdvertisementMapper extends BaseMapper<Advertisement> {

    @Select("select id as id,advertisement_image as advertisement_image," +
            "create_time as create_time," +
            "update_time as update_time," +
            "is_delete as is_delete from advertisement")
    public List<Advertisement> findAll();

    @Insert("insert into advertisement(advertisement_image,create_time,update_time,is_delete) values(#{advertisementImage},now(),now(),0)")
    public void add(Advertisement advertisement);

    @Update("update advertisement set is_delete=1 where id=#{id}")
    public void forbid(Advertisement advertisement);

    @Update("update advertisement set is_delete=0 where id=#{id}")
    public void activate(Advertisement advertisement);

    @Select("select * from advertisement where id=#{id}")
    public Advertisement getAdvertisementById(long id);
}
