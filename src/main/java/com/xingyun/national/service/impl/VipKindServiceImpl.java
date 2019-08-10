package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.VipKind;
import com.xingyun.national.mapper.VipKindMapper;
import com.xingyun.national.service.IVipKindService;
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
 * @since 2019-07-17
 */
@Service
public class VipKindServiceImpl extends ServiceImpl<VipKindMapper, VipKind> implements IVipKindService {

    @Autowired
    private VipKindMapper vipKindMapper;

    @Override
    public PageInfo<VipKind> findVipKind(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<VipKind> list=vipKindMapper.findVipKind();
        PageInfo<VipKind> pageInfo= new PageInfo<VipKind>(list);
        return pageInfo;
    }

    @Override
    public VipKind getAllById(long id) {
        return this.vipKindMapper.findById(id);
    }

    @Override
    public List<VipKind> findAll() {
        return this.vipKindMapper.findVipKind();
    }
}
