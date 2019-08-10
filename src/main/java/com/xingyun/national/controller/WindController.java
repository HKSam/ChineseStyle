package com.xingyun.national.controller;


import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.Wind;
import com.xingyun.national.entity.WindDetails;
import com.xingyun.national.service.IWindDetailsService;
import com.xingyun.national.service.IWindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
@Controller
@RequestMapping("/wind")
public class WindController {

    @Autowired
    private IWindDetailsService iWindDetailsService;

    @Autowired
    private IWindService iWindService;

    @RequestMapping("/windlist")
    public String windlist(Model model){
        List<Wind> winds=iWindService.getWinds();
        model.addAttribute("winds",winds);
        return "wind/windlist";
    }

    @RequestMapping("getWind")
    @ResponseBody
    public Map<String,Object> getWind(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<Wind> pageList =  iWindService.findWind(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }
    @RequestMapping("/windDetails")
    public String windDetails(Model model){
        List<WindDetails> windDetails=iWindDetailsService.getWindDetails();
        model.addAttribute("windDetails",windDetails);
        return "wind/windDetails";
    }

    @RequestMapping("getWindDetails")
    @ResponseBody
    public Map<String,Object> getWindDetails(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<WindDetails> pageList =  iWindDetailsService.findWindDetails(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    @RequestMapping(value = "/addwind",method = RequestMethod.GET)
    public String addwind(){
        return "wind/addwind";
    }

    @RequestMapping(value = "/addwind",method = RequestMethod.POST)
    public String addwind(Wind wind)
    {

        this.iWindService.insertWinds(wind);
        return "redirect:/wind/windlist";
    }



    @RequestMapping(value = "/addwindDetails",method = RequestMethod.GET)
    public String addwindDetails(){
        return "wind/addwindDetails";
    }

    @RequestMapping(value = "/addwindDetails",method = RequestMethod.POST)
    public String addwindDetails(WindDetails windDetails)
    {
//        String content=windDetails.getContent().replaceAll("<[.[^<]]*>","");
//        windDetails.setContent(content);
        this.iWindDetailsService.saveOrUpdate(windDetails);
        return "redirect:/wind/windDetails";
    }



    @RequestMapping(value = "/editwind/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model){
        Wind wind=this.iWindService.getWindById(id);
        model.addAttribute("wind",wind);
        return "wind/editwind";
    }


    @RequestMapping(value = "/editwind",method = RequestMethod.POST)
    public String edit(Wind wind){
        this.iWindService.updateWind(wind);
        return "redirect:/wind/windlist";
    }

    @RequestMapping(value = "/editwindDetails/{id}",method = RequestMethod.GET)
    public String editwindDetails(@PathVariable long id, Model model){
        WindDetails windDetails=this.iWindDetailsService.getWindDetailsById(id);
        model.addAttribute("windDetails",windDetails);
        return "wind/editwindDetails";
    }

    @RequestMapping(value = "/editwindDetails",method = RequestMethod.POST)
    public String editwindDetails(WindDetails windDetails){
//        String content=windDetails.getContent().replaceAll("<[.[^<]]*>","");
//        windDetails.setContent(content);
        this.iWindDetailsService.saveOrUpdate(windDetails);
        return "redirect:/wind/windDetails";
    }

    @ResponseBody
    @RequestMapping("/deleteWind/{id}")
    public JsonResult deleteWinds(@PathVariable long id){
        this.iWindService.removeById(id);
        return JsonResult.success("删除成功！");
    }

    @ResponseBody
    @RequestMapping("/deleteDetails/{id}")
    public JsonResult deleteDetails(@PathVariable long id){
        this.iWindDetailsService.removeById(id);
        return JsonResult.success("删除成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/activateWind/{id}",method = RequestMethod.POST)
    public JsonResult activateWind(@PathVariable long id){
        try {

            Wind wind = iWindService.getWindById(id);
            if (wind.getIsDelete() == 1) {
                wind.setIsDelete(0);
                iWindService.saveOrUpdate(wind);

            } else {
                return JsonResult.failure("该国风已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("激活成功");

    }

    @ResponseBody
    @RequestMapping(value = "/forbidWind/{id}",method = RequestMethod.POST)
    public JsonResult forbidWind(@PathVariable long id)
    {
        try {

            Wind wind = iWindService.getWindById(id);
            if (wind.getIsDelete() == 0) {
                wind.setIsDelete(1);
                iWindService.saveOrUpdate(wind);

            } else {
                return JsonResult.failure("该国风已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁用成功！");
    }
}
