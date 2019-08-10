package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Activity;
import com.xingyun.national.mapper.ActivityMapper;
import com.xingyun.national.service.IActivityService;
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
 * @since 2019-07-09
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;



    public List<Activity> getActivitys(){
        return this.activityMapper.findAll();
    }

    public Activity getActivity(long id){
        return activityMapper.getActivityById(id);
    }

    public void addActivity(Activity activity){
        this.activityMapper.add(activity);
    }

    @Override
    public PageInfo<Activity> findActivity(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<Activity> list=activityMapper.findAll();
        PageInfo<Activity> pageInfo= new PageInfo<Activity>(list);
        return pageInfo;
    }

    @Override
    public long countActivity() {
        return this.activityMapper.countAll();
    }
}
