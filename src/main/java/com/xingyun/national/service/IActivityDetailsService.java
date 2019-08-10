package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Activity;
import com.xingyun.national.entity.ActivityDetails;
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
public interface IActivityDetailsService extends IService<ActivityDetails> {

    public List<ActivityDetails> getActivityDetails();

    public void addDetails(ActivityDetails activityDetails);

    public ActivityDetails getActivityDetails(long id);

    public PageInfo<ActivityDetails> findActivityDetails(int page,int limit);
}
