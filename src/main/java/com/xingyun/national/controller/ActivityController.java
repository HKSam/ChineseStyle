package com.xingyun.national.controller;


import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.Activity;
import com.xingyun.national.entity.ActivityDetails;
import com.xingyun.national.entity.Advertisement;
import com.xingyun.national.service.IActivityDetailsService;
import com.xingyun.national.service.IActivityService;
import com.xingyun.national.service.IAdvertisementService;
import com.xingyun.national.service.impl.ActivityServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  活动管理控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService iActivityService;

    @Autowired
    private IActivityDetailsService iActivityDetailsService;

    @ApiOperation("返回活动列表")
    @RequestMapping("/activitylist")
    public String activitylist(Model model){
//        List<Activity> activities=iActivityService.getActivitys();
//        model.addAttribute("activities",activities);
        return "activity/activitylist";

    }

    /**
     * 返回活动详情页面
     */
    @ApiOperation("返回活动详情页面")
    @RequestMapping("/activityDetailslist")
    public String activityD(Model model){
        List<ActivityDetails> activityDetails=iActivityDetailsService.getActivityDetails();
        model.addAttribute("activityDetails",activityDetails);
        return "activity/activityDetailslist";
    }


    @ApiOperation("活动列表API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "10"),
    })
    @RequestMapping("getActivity")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<Activity> activityList =  iActivityService.findActivity(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",activityList.getList());
        map.put("count",activityList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     * 活动详情-传输分页数据和接口标准实现分页
     */
    @ApiOperation("活动详情列表API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "5"),
    })
    @RequestMapping("getActivityDetails")
    @ResponseBody
    public Map<String,Object> getActivityDetails(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<ActivityDetails> pageList =  iActivityDetailsService.findActivityDetails(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     * 删除活动
     */
    @ApiOperation("删除活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public JsonResult delete(@PathVariable Integer id){
        this.iActivityService.removeById(id);
        return JsonResult.success("删除成功！");
    }

    /**
     * 删除活动详情
     */
    @ApiOperation("删除活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动详情的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/deleteDetails/{id}",method = RequestMethod.POST)
    public JsonResult deleteDetails(@PathVariable long id){
        this.iActivityDetailsService.removeById(id);
        return JsonResult.success("删除成功！");
    }


    /**
     * 返回添加活动页面
     */
    @ApiOperation("返回添加活动页面")
    @RequestMapping(value = "/addactivity",method = RequestMethod.GET)
    public String addactivity(){
        return "activity/addactivity";
    }


    /**
     * 实现添加活动
     */
    @ApiOperation("实现添加活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activity", value = "活动实体类对象"),
    })
    @RequestMapping(value = "/addactivity",method = RequestMethod.POST)
    public String addactivity(Activity activity)
    {
        this.iActivityService.addActivity(activity);
        return "redirect:/activity/activitylist";
    }

    /**
     * 返回添加详情页面
     */
    @ApiOperation("返回添加详情页面")
    @RequestMapping(value = "/addDetails",method = RequestMethod.GET)
    public String addDetails(){
        return "activity/addDetails";
    }

    /**
     * 添加
     */
    @ApiOperation("添加详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activity", value = "活动详情实体类对象"),
    })
    @RequestMapping(value = "/addDetails",method = RequestMethod.POST)
    public String addDetails(ActivityDetails activityDetails)
    {
//        String content=activityDetails.getContent().replaceAll("<[.[^<]]*>","");
//        activityDetails.setContent(content);
        this.iActivityDetailsService.addDetails(activityDetails);
        return "redirect:/activity/activityDetailslist";
    }

    @ApiOperation("编辑活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动详情的自增id"),
    })
    @RequestMapping(value = "/editActivity/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model){
        Activity activity=this.iActivityService.getActivity(id);
        model.addAttribute("activity",activity);
        return "activity/editactivity";
    }


    @ApiOperation("编辑活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activity", value = "活动实体类对象"),
    })
    @RequestMapping(value = "/editActivity",method = RequestMethod.POST)
    public String edit(Activity activity){
        this.iActivityService.saveOrUpdate(activity);
        return "redirect:/activity/activitylist";
    }

    @ApiOperation("编辑活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动详情的自增id"),
    })
    @RequestMapping(value = "/editADetail/{id}",method = RequestMethod.GET)
    public String editwindDetails(@PathVariable long id, Model model){
        ActivityDetails activityDetails=this.iActivityDetailsService.getActivityDetails(id);
        model.addAttribute("activityDetails",activityDetails);
        return "activity/editADetail";
    }

    @ApiOperation("编辑活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityDetails", value = "活动详情实体类的对象"),
    })
    @RequestMapping(value = "/editADetail",method = RequestMethod.POST)
    public String editDetails(ActivityDetails activityDetails){
//        String content=windDetails.getContent().replaceAll("<[.[^<]]*>","");
//        windDetails.setContent(content);
        this.iActivityDetailsService.saveOrUpdate(activityDetails);
        return "redirect:/activity/activityDetailslist";
    }
    /**
     * 激活
     */
    @ApiOperation("激活活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/activate/{id}",method = RequestMethod.POST)
    public JsonResult activate(@PathVariable Integer id)
    {
        try {

            Activity activity = iActivityService.getActivity(id);
            if (activity.getIsDelete() == 1) {
                activity.setIsDelete(0);
                iActivityService.saveOrUpdate(activity);

            } else {
                return JsonResult.failure("当前活动已激活");
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
    @ApiOperation("禁用活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/forbid/{id}",method = RequestMethod.POST)
    public JsonResult forbid(@PathVariable Integer id)
    {
        try {

            Activity activity = iActivityService.getActivity(id);
            if (activity.getIsDelete() == 0) {
                activity.setIsDelete(1);
                iActivityService.saveOrUpdate(activity);

            } else {
                return JsonResult.failure("当前活动已禁用");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁用成功！");
    }

    /**
     * 激活
     */
    @ApiOperation("激活活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动详情的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/activateDetails/{id}",method = RequestMethod.POST)
    public JsonResult activateDetails(@PathVariable long id){
        try {

            ActivityDetails activityDetails=iActivityDetailsService.getActivityDetails(id);
            if (activityDetails.getIsDelete() == 1) {
                activityDetails.setIsDelete(0);
                iActivityDetailsService.saveOrUpdate(activityDetails);

            } else {
                return JsonResult.failure("当前活动详情已激活！");
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
    @ApiOperation("禁用活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "活动详情的自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/forbidDetails/{id}",method = RequestMethod.POST)
    public JsonResult forbidDetails(@PathVariable long id)
    {
        try {

            ActivityDetails activityDetails=iActivityDetailsService.getActivityDetails(id);
            if (activityDetails.getIsDelete() ==0) {
                activityDetails.setIsDelete(1);
                iActivityDetailsService.saveOrUpdate(activityDetails);

            } else {
                return JsonResult.failure("该活动详情已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁用成功！");
    }
}
