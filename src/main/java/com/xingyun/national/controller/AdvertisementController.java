package com.xingyun.national.controller;


import antlr.PrintWriterWithSMAP;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.Advertisement;
import com.xingyun.national.service.IAdvertisementService;
import com.xingyun.national.service.impl.AdvertisementServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javafx.print.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Controller
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private IAdvertisementService iAdvertisementService;
    @RequestMapping("/adverlist")
    public String adverlist(Model model){
        List<Advertisement> advertisements=iAdvertisementService.getAdvertisements();
        model.addAttribute("advertisements",advertisements);
        return "advertisement/adverlist";
    }

    /**
     * 分页查询广告信息
     */
    @ApiOperation("分页查询广告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "10"),
    })
    @RequestMapping("getAdvertisement")
    @ResponseBody
    public Map<String,Object> getAdvertisement(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<Advertisement> pageList =  iAdvertisementService.findAdvertisement(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     * 添加广告
     */
    @ApiOperation("添加广告")
    @RequestMapping(value = "/addadver",method = RequestMethod.GET)
    public String addadver(){
        return "advertisement/addadver";
    }

    @RequestMapping(value = "/addadver",method = RequestMethod.POST)
    public String addadver(Advertisement advertisement)
    {

        this.iAdvertisementService.addAdvertisements(advertisement);
        return "redirect:/advertisement/adverlist";
    }

    /**
     * 删除
     */
    @ApiOperation("删除广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "广告自增的id"),
    })
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public JsonResult delete(@PathVariable long id){
        this.iAdvertisementService.removeById(id);
        return JsonResult.success("删除成功！");
    }

    /**
     * 编辑广告
     */
    @ApiOperation("编辑广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "广告的实体类对象"),
    })
    @RequestMapping(value = "/editAdver/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model){
        Advertisement advertisement=this.iAdvertisementService.getAdvertisement(id);
        model.addAttribute("advertisement",advertisement);
        return "advertisement/editadver";
    }

    @ApiOperation("编辑广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "advertisement", value = "广告的实体类对象"),
    })
    @RequestMapping(value = "/editAdver",method = RequestMethod.POST)
    public String edit(Advertisement advertisement){
        this.iAdvertisementService.saveOrUpdate(advertisement);
        return "redirect:/advertisement/adverlist";
    }

    /**
     * 激活
     */
    @ApiOperation("激活广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "广告的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/activate/{id}",method = RequestMethod.POST)
    public JsonResult activate(@PathVariable long id){
        try {

            Advertisement advertisement = iAdvertisementService.getAdvertisement(id);
            if (advertisement.getIsDelete() == 1) {
                advertisement.setIsDelete(0);
                iAdvertisementService.saveOrUpdate(advertisement);

            } else {
                return JsonResult.failure("该广告已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("激活成功！");

    }

    /**
     * 禁用
     */
    @ApiOperation("禁用广告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "广告的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/forbid/{id}",method = RequestMethod.POST)
    public JsonResult forbid(@PathVariable long id)
    {
        try {

            Advertisement advertisement = iAdvertisementService.getAdvertisement(id);
            if (advertisement.getIsDelete() == 0) {
                advertisement.setIsDelete(1);
                iAdvertisementService.saveOrUpdate(advertisement);

            } else {
                return JsonResult.failure("该广告已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁用成功！");
    }
}
