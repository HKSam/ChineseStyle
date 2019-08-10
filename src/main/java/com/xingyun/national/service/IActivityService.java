package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Activity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
public interface IActivityService extends IService<Activity> {

    public List<Activity> getActivitys();
    public Activity getActivity(long id);
    public void addActivity(Activity activity);
    public PageInfo<Activity> findActivity(int page , int limit);
    public long countActivity();
}
