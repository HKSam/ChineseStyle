package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.UserCoin;
import com.xingyun.national.mapper.UserCoinMapper;
import com.xingyun.national.service.IUserCoinService;
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
public class UserCoinServiceImpl extends ServiceImpl<UserCoinMapper, UserCoin> implements IUserCoinService {

    @Autowired
    private UserCoinMapper userCoinMapper;

    public List<UserCoin> getUserCoins(){
        return userCoinMapper.findAll();
    }

    @Override
    public PageInfo<UserCoin> findUserCoins(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<UserCoin> list=userCoinMapper.findAll();
        PageInfo<UserCoin> pageInfo= new PageInfo<UserCoin>(list);
        return pageInfo;
    }
}
