package com.xingyun.national.service;

import com.xingyun.national.entity.Rank;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
public interface IRankService extends IService<Rank> {

    public List<Rank> getRanks();

    public Rank getRankById(long id);

    public void updateRank(Rank rank);
}
