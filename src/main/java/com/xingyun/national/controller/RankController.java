package com.xingyun.national.controller;


import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.Rank;
import com.xingyun.national.service.IRankService;
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
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private IRankService iRankService;

    @RequestMapping("/ranklist")
    public String ranklist(Model model){
        List<Rank> ranks=iRankService.getRanks();
        model.addAttribute("ranks",ranks);
        return "/rank/ranklist";
    }

    @RequestMapping(value = "/addrank",method = RequestMethod.GET)
    public String addrank(){
        return "rank/addrank";
    }

    @RequestMapping(value = "/addrank",method = RequestMethod.POST)
    public String addrank(Rank rank)
    {

        this.iRankService.saveOrUpdate(rank);
        return "redirect:/rank/ranklist";
    }
    @RequestMapping(value = "/editrank",method = RequestMethod.GET)
    public String edit(long id, Model model){
        Rank rank=this.iRankService.getRankById(id);
        model.addAttribute("rank",rank);
        return "rank/editrank";
    }

    @RequestMapping(value = "/editrank",method = RequestMethod.POST)
    public String edit(Rank rank){
        this.iRankService.updateRank(rank);
        return "redirect:/rank/ranklist";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        this.iRankService.removeById(id);
        return "redirect:/rank/ranklist";
    }
}
