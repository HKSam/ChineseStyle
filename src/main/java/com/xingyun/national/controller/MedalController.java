package com.xingyun.national.controller;


import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.Medal;
import com.xingyun.national.service.IMedalService;
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
@RequestMapping("/medal")
public class MedalController {

    @Autowired
    private IMedalService iMedalService;

    @RequestMapping("/medallist")
    public String medallist(Model model){
        List<Medal> medals =iMedalService.getMedals();
        model.addAttribute("medals",medals);
        return "medal/medallist";
    }

    @RequestMapping(value = "/addmedal",method = RequestMethod.GET)
    public String addmedal(){
        return "medal/addmedal";
    }

    @RequestMapping(value = "/addmedal",method = RequestMethod.POST)
    public String addmedal(Medal medal)
    {

        this.iMedalService.saveOrUpdate(medal);
        return "redirect:/medal/medallist";
    }
    @RequestMapping(value = "/editmedal",method = RequestMethod.GET)
    public String edit(long id, Model model){
        Medal medal=this.iMedalService.getMedalById(id);
        model.addAttribute("medal",medal);
        return "medal/editmedal";
    }

    @RequestMapping(value = "/editmedal",method = RequestMethod.POST)
    public String edit(Medal medal){
        this.iMedalService.saveOrUpdate(medal);
        return "redirect:/medal/medallist";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        this.iMedalService.removeById(id);
        return "redirect:/medal/medallist";
    }
}
