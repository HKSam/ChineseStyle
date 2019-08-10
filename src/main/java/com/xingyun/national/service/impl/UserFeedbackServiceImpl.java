package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.UserFeedback;
import com.xingyun.national.mapper.UserFeedbackMapper;
import com.xingyun.national.service.IUserFeedbackService;
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
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback> implements IUserFeedbackService {

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    public List<UserFeedback> getUserFeedBacks(){
        return userFeedbackMapper.findAll();
    }

    @Override
    public PageInfo<UserFeedback> findFeedBack(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<UserFeedback> list=userFeedbackMapper.findAll();
        PageInfo<UserFeedback> pageInfo= new PageInfo<UserFeedback>(list);
        return pageInfo;
    }

    @Override
    public UserFeedback getUserFeedBackById(long id) {
        return this.userFeedbackMapper.getById(id);
    }
}
