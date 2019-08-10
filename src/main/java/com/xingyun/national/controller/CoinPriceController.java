package com.xingyun.national.controller;


import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.CoinPrice;
import com.xingyun.national.service.ICoinPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
@Controller
@RequestMapping("/coin")
public class CoinPriceController {

    @Autowired
    private ICoinPriceService iCoinPriceServicel;

    @RequestMapping("/price")
    public String price(Model model){
        List<CoinPrice> coinPrices=iCoinPriceServicel.getCoinPrices();
        model.addAttribute("coinPrices",coinPrices);
        return "coin/price";
    }

    @RequestMapping(value = "/addCoinPrice",method = RequestMethod.GET)
    public String addadver(){
        return "coin/addCoinPrice";
    }

    @RequestMapping(value = "/addCoinPrice",method = RequestMethod.POST)
    public String addadver(CoinPrice coinPrice)
    {

        this.iCoinPriceServicel.saveOrUpdate(coinPrice);
        return "redirect:/coin/price";
    }
    @RequestMapping(value = "/editcoin",method = RequestMethod.GET)
    public String edit(long id, Model model){
        CoinPrice coinPrice=this.iCoinPriceServicel.getCoinPrice(id);
        model.addAttribute("coinPrice",coinPrice);
        return "coin/editcoin";
    }

    @RequestMapping(value = "/editcoin",method = RequestMethod.POST)
    public String edit(CoinPrice coinPrice){
        this.iCoinPriceServicel.updateCoinPrices(coinPrice);
        return "redirect:/coin/price";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        this.iCoinPriceServicel.removeById(id);
        return "redirect:/coin/price";
    }
}
