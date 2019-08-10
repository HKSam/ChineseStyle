package com.xingyun.national.service;

import com.xingyun.national.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-07
 */
public interface IAdminUserService extends IService<AdminUser> {



    public AdminUser login(String name,String password);
}
