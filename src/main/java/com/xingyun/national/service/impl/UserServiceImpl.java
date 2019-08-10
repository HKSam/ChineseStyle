package com.xingyun.national.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.ResultGenerator;
import com.xingyun.national.dto.Userdto;
import com.xingyun.national.entity.User;
import com.xingyun.national.mapper.UserMapper;
import com.xingyun.national.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.findAll();
    };

    public void deleteUser(long id){
        this.userMapper.delete(id);
    }

    public User getUser(long id){
        return this.userMapper.getUserById(id);
    }

    public void updateUser(User user){
        this.userMapper.updateAll(user);
    }


    public PageInfo<Userdto>  findUser(int page ,int limit){
        PageHelper.startPage(1,10);

        List<Userdto> list=userMapper.findAllUser();
        PageInfo<Userdto> pageInfo= new PageInfo<Userdto>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<User> getAllByName(int page, int limit, String name) {
        PageHelper.startPage(1,10);

        List<User> list=userMapper.findAllByName(name);
        PageInfo<User> pageInfo= new PageInfo<User>(list);
        return pageInfo;
    }

    //    @Override
//    public List<User> toQuery(User user) {
//
//        StringBuilder sql=new StringBuilder("select * from user where 1=1");
//        List<Object> params=new ArrayList<Object>();
//        String nickName=user.getNickName();
//        if(nickName!=null&&nickName.trim().isEmpty()){
//            sql.append("and nick_name like ?");
//            params.add("%"+nickName+"%");
//        }
//
//        String gender=user.getGender().toString();
//        if(gender!=null&&gender.trim().isEmpty()){
//            sql.append("and gender like ?");
//            params.add("%"+gender+"%");
//        }
//
//        String city=user.getCity();
//        if(city!=null&&city.trim().isEmpty()){
//            sql.append("and city like ?");
//            params.add("%"+city+"%");
//        }
//
//        String province=user.getProvince();
//        if(province!=null&&province.trim().isEmpty()){
//            sql.append("and province like ?");
//            params.add("%"+province+"%");
//        }
//
//        String country=user.getCountry();
//        if(country!=null&&country.trim().isEmpty()){
//            sql.append("and country like ?");
//            params.add("%"+country+"%");
//        }
//
//
//    }




    @Override
    public long countUser() {
        return this.userMapper.countAll();
    }

    @Override
    public List<Userdto> getUserdto() {
        return this.userMapper.findAllUser();
    }
}
