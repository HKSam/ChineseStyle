package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.ActivityDetails;
import com.xingyun.national.mapper.ActivityDetailsMapper;
import com.xingyun.national.service.IActivityDetailsService;
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
public class ActivityDetailsServiceImpl extends ServiceImpl<ActivityDetailsMapper, ActivityDetails> implements IActivityDetailsService {

    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;

    public List<ActivityDetails> getActivityDetails(){
        return activityDetailsMapper.findAll();
    }

    public void addDetails(ActivityDetails activityDetails){
         activityDetailsMapper.add(activityDetails);
    }

    @Override
    public ActivityDetails getActivityDetails(long id) {
        return this.activityDetailsMapper.getActivityDetailsById(id);
    }

    @Override
    public PageInfo<ActivityDetails> findActivityDetails(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<ActivityDetails> list=activityDetailsMapper.findAll();
        PageInfo<ActivityDetails> pageInfo= new PageInfo<ActivityDetails>(list);
        return pageInfo;
    }
}
