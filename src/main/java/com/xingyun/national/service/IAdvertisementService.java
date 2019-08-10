package com.xingyun.national.service;

import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Advertisement;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
public interface IAdvertisementService extends IService<Advertisement> {

    public List<Advertisement> getAdvertisements();

    public void addAdvertisements(Advertisement advertisement);

    public void activateAdvertisement(Advertisement advertisement);

    public void forbidAdvertisement(Advertisement advertisement);

    public Advertisement getAdvertisement(long id);

    public PageInfo<Advertisement> findAdvertisement(int page,int limit);
}
