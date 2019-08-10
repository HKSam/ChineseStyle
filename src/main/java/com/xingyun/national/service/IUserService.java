package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.ResultGenerator;
import com.xingyun.national.dto.Userdto;
import com.xingyun.national.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xingyun.national.entity.UserVipInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
public interface IUserService extends IService<User> {


    public List<User> getUsers();

    public void deleteUser(long id);

    public User getUser(long id);

    public void updateUser(User user);

    public PageInfo<Userdto>  findUser(int page ,int limit);

    public long countUser();

    public List<Userdto> getUserdto();

    public PageInfo<User> getAllByName(int page ,int limit ,String name);
}
