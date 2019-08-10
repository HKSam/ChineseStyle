package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Wind;
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
public interface IWindService extends IService<Wind> {

    public List<Wind> getWinds();

    public Wind getWindById(long id);

    public void updateWind(Wind wind);

    public void insertWinds(Wind wind);

    public PageInfo<Wind> findWind(int page , int limit);

    public long countWind();
}
