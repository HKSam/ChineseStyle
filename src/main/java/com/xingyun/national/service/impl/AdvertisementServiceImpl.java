package com.xingyun.national.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.entity.Advertisement;
import com.xingyun.national.mapper.AdvertisementMapper;
import com.xingyun.national.service.IAdvertisementService;
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
 * @since 2019-07-09
 */
@Service
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper, Advertisement> implements IAdvertisementService {

    @Autowired
    private AdvertisementMapper advertisementMapper;

    public List<Advertisement> getAdvertisements(){
        return this.advertisementMapper.findAll();
    }

    public void addAdvertisements(Advertisement advertisement){
        this.advertisementMapper.add(advertisement);
    }

    public void forbidAdvertisement(Advertisement advertisement){
        this.advertisementMapper.forbid(advertisement);
    }

    public void activateAdvertisement(Advertisement advertisement){
        this.advertisementMapper.activate(advertisement);
    }

    public Advertisement getAdvertisement(long id){
        return this.advertisementMapper.getAdvertisementById(id);
    }

    @Override
    public PageInfo<Advertisement> findAdvertisement(int page, int limit) {
        PageHelper.startPage(page,limit);

        List<Advertisement> list=advertisementMapper.findAll();
        PageInfo<Advertisement> pageInfo= new PageInfo<Advertisement>(list);
        return pageInfo;
    }
}
