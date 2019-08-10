package com.xingyun.national.service;

import com.xingyun.national.entity.CoinPrice;
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
public interface ICoinPriceService extends IService<CoinPrice> {

    public List<CoinPrice> getCoinPrices();

    public void updateCoinPrices(CoinPrice coinPrice);

    public CoinPrice getCoinPrice(long id);
}
