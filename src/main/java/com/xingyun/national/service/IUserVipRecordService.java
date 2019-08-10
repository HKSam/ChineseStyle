package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.UserVipRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-17
 */

public interface IUserVipRecordService extends IService<UserVipRecord> {
    public PageInfo<UserVipRecord> findVipRecord(int page, int limit);
}
