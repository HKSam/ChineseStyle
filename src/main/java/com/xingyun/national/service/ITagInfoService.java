package com.xingyun.national.service;

import com.xingyun.national.entity.TagInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
public interface ITagInfoService extends IService<TagInfo> {

    public List<TagInfo> getTagInfos();
}
