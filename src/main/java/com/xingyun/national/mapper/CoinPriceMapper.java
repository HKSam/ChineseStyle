package com.xingyun.national.mapper;

import com.xingyun.national.entity.CoinPrice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
@Component
public interface CoinPriceMapper extends BaseMapper<CoinPrice> {

    @Select("select * from coin_price")
    public List<CoinPrice> findAll();

    @Update("update coin_price set " +
            "coin_cost=#{coinCost}," +
            "price=#{price} where id=#{id}")
    public void updateAll(CoinPrice coinPrice);

    @Select("select * from coin_price where id=#{id}")
    public CoinPrice getCoinById(long id);


}
