package com.xingyun.national.mapper;

import com.xingyun.national.entity.VipKind;
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
public interface VipKindMapper extends BaseMapper<VipKind> {
    @Select("select * from vip_kind")
    public List<VipKind> findVipKind();

    @Select("select * from vip_kind where id=#{id}")
    public VipKind findById(long id);
}
