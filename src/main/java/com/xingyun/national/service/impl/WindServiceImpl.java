package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Wind;
import com.xingyun.national.mapper.WindMapper;
import com.xingyun.national.service.IWindService;
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
public class WindServiceImpl extends ServiceImpl<WindMapper, Wind> implements IWindService {

    @Autowired
    private WindMapper windMapper;
    public List<Wind> getWinds(){
        return windMapper.findAll();
    }

    @Override
    public void updateWind(Wind wind) {
        this.windMapper.updateWind(wind);
    }

    @Override
    public Wind getWindById(long id) {
        return  this.windMapper.getWindById(id);
    }

    @Override
    public void insertWinds(Wind wind) {
        this.windMapper.insertWind(wind);
    }

    @Override
    public PageInfo<Wind> findWind(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<Wind> list=windMapper.findAll();
        PageInfo<Wind> pageInfo= new PageInfo<Wind>(list);
        return pageInfo;
    }

    @Override
    public long countWind() {
        return this.windMapper.countAll();
    }
}
