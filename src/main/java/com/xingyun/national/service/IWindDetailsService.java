package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.WindDetails;
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
public interface IWindDetailsService extends IService<WindDetails> {

    public List<WindDetails> getWindDetails();

    public WindDetails getWindDetailsById(long id);

    public void updateWindDetails(WindDetails windDetails);

    public PageInfo<WindDetails> findWindDetails(int page,int limit);
}
