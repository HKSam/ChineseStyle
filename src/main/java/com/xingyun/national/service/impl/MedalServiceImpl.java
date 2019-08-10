package com.xingyun.national.service.impl;

import com.xingyun.national.entity.Medal;
import com.xingyun.national.mapper.MedalMapper;
import com.xingyun.national.service.IMedalService;
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
public class MedalServiceImpl extends ServiceImpl<MedalMapper, Medal> implements IMedalService {

    @Autowired
    private MedalMapper medalMapper;

    public List<Medal> getMedals(){
        return medalMapper.getMedals();
    }

    @Override
    public Medal getMedalById(long id) {
        return this.medalMapper.getMedalById(id);
    }
}
