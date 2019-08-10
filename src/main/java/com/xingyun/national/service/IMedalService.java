package com.xingyun.national.service;

import com.xingyun.national.entity.Medal;
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
public interface IMedalService extends IService<Medal> {

    public List<Medal> getMedals();

    public Medal getMedalById(long id);
}
