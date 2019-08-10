package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.UserVipRecord;
import com.xingyun.national.mapper.UserVipInfoMapper;
import com.xingyun.national.mapper.UserVipRecordMapper;
import com.xingyun.national.service.IUserVipRecordService;
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
public class UserVipRecordServiceImpl extends ServiceImpl<UserVipRecordMapper, UserVipRecord> implements IUserVipRecordService {

    @Autowired
    private UserVipRecordMapper userVipRecordMapper;

    @Override
    public PageInfo<UserVipRecord> findVipRecord(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<UserVipRecord> list=userVipRecordMapper.findVipRecord();
        PageInfo<UserVipRecord> pageInfo= new PageInfo<UserVipRecord>(list);
        return pageInfo;
    }
}
