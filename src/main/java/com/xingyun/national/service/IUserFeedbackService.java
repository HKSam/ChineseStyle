package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.UserFeedback;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 * @author CYS
 * @since 2019-07-10
 */
public interface IUserFeedbackService extends IService<UserFeedback> {

    public List<UserFeedback> getUserFeedBacks();

    public PageInfo<UserFeedback> findFeedBack(int page , int limit);

    public UserFeedback getUserFeedBackById(long id);
}
