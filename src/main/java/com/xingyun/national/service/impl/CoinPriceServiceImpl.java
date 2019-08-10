package com.xingyun.national.service.impl;

import com.xingyun.national.entity.CoinPrice;
import com.xingyun.national.mapper.CoinPriceMapper;
import com.xingyun.national.service.ICoinPriceService;
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
public class CoinPriceServiceImpl extends ServiceImpl<CoinPriceMapper, CoinPrice> implements ICoinPriceService {

    @Autowired
    private CoinPriceMapper coinPriceMapper;

    public List<CoinPrice> getCoinPrices(){
        return coinPriceMapper.findAll();
    }

    public void updateCoinPrices(CoinPrice price){
        coinPriceMapper.updateAll(price);
    }

    public CoinPrice getCoinPrice(long id){
        return this.coinPriceMapper.getCoinById(id);
    }
}
