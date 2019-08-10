package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.dto.Vipdto;
import com.xingyun.national.entity.UserVipInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-17
 */
public interface IUserVipInfoService extends IService<UserVipInfo> {

    public PageInfo<Vipdto> findVip(int page, int limit);

    public long countVip();

}
