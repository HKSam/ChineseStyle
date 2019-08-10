package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.dto.Vipdto;
import com.xingyun.national.entity.User;
import com.xingyun.national.entity.UserVipInfo;
import com.xingyun.national.mapper.UserVipInfoMapper;
import com.xingyun.national.service.IUserVipInfoService;
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
public class UserVipInfoServiceImpl extends ServiceImpl<UserVipInfoMapper, UserVipInfo> implements IUserVipInfoService {

    @Autowired
    private UserVipInfoMapper userVipInfoMapper;

    @Override
    public PageInfo<Vipdto> findVip(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Vipdto> list=userVipInfoMapper.findVip();
        PageInfo<Vipdto> pageInfo= new PageInfo<Vipdto>(list);
        return pageInfo;
    }

    @Override
    public long countVip() {
        return this.userVipInfoMapper.countAll();
    }
}
