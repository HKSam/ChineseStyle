package com.xingyun.national.service.impl;

import com.xingyun.national.entity.TagInfo;
import com.xingyun.national.mapper.TagInfoMapper;
import com.xingyun.national.service.ITagInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
@Service
public class TagInfoServiceImpl extends ServiceImpl<TagInfoMapper, TagInfo> implements ITagInfoService {

    @Autowired
    private TagInfoMapper tagInfoMapper;

    public List<TagInfo> getTagInfos(){
        return tagInfoMapper.findAll();
    }
}
