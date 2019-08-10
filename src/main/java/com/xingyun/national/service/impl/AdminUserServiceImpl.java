package com.xingyun.national.service.impl;

import com.xingyun.national.entity.AdminUser;
import com.xingyun.national.mapper.AdminUserMapper;
import com.xingyun.national.service.IAdminUserService;
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
 * @since 2019-07-07
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;



    @Override
    public AdminUser login(String name, String password) {
        AdminUser adminUser=this.adminUserMapper.getUserByName(name);
        if(adminUser==null)
            return null;
        if(adminUser.getPassword().equals(password))
            return adminUser;
        return null;
    }
}
