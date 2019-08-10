package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.WindDetails;
import com.xingyun.national.mapper.WindDetailsMapper;
import com.xingyun.national.service.IWindDetailsService;
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
public class WindDetailsServiceImpl extends ServiceImpl<WindDetailsMapper, WindDetails> implements IWindDetailsService {

    @Autowired
    private WindDetailsMapper windDetailsMapper;

    public List<WindDetails> getWindDetails(){
        return windDetailsMapper.findAll();
    }

    @Override
    public void updateWindDetails(WindDetails windDetails) {
        this.windDetailsMapper.updateWind(windDetails);
    }

    @Override
    public WindDetails getWindDetailsById(long id) {
        return this.windDetailsMapper.getWindDetailsById(id);
    }

    @Override
    public PageInfo<WindDetails> findWindDetails(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<WindDetails> list=windDetailsMapper.findAll();
        PageInfo<WindDetails> pageInfo= new PageInfo<WindDetails>(list);
        return pageInfo;
    }
}
