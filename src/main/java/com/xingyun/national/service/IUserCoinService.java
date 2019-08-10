package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.UserCoin;
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
public interface IUserCoinService extends IService<UserCoin> {

    public List<UserCoin> getUserCoins();

    public PageInfo<UserCoin> findUserCoins(int page , int limit);
}
