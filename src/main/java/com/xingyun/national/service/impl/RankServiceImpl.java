package com.xingyun.national.service.impl;

import com.xingyun.national.entity.Rank;
import com.xingyun.national.mapper.RankMapper;
import com.xingyun.national.service.IRankService;
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
public class RankServiceImpl extends ServiceImpl<RankMapper, Rank> implements IRankService {

    @Autowired
    private RankMapper rankMapper;

    public List<Rank> getRanks(){
        return rankMapper.findAll();
    }

    public Rank getRankById(long id){
        return rankMapper.getRankById(id);
    }

    public void updateRank(Rank rank){
        this.rankMapper.updateAll(rank);
    }
}
