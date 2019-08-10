package com.xingyun.national.mapper;

import com.xingyun.national.entity.TagInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.swing.text.html.HTML;
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
public interface TagInfoMapper extends BaseMapper<TagInfo> {

    @Select("select * from tag_info")
    public List<TagInfo> findAll();
}
