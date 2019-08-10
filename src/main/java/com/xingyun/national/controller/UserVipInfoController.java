package com.xingyun.national.controller;


import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.dto.Vipdto;
import com.xingyun.national.entity.User;
import com.xingyun.national.entity.UserVipInfo;
import com.xingyun.national.entity.UserVipRecord;
import com.xingyun.national.entity.VipKind;
import com.xingyun.national.service.IUserVipInfoService;
import com.xingyun.national.service.IUserVipRecordService;
import com.xingyun.national.service.IVipKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @since 2019-07-17
 */
@Controller
@RequestMapping("/vip")
public class UserVipInfoController {

    @Autowired
    private IUserVipInfoService iUserVipInfoService;

    @Autowired
    private IUserVipRecordService iUserVipRecordService;

    @Qualifier("vipKindServiceImpl")
    @Autowired
    private IVipKindService iVipKindService;

    @RequestMapping("/viplist")
    public String list(){

        return "vip/viplist";
    }

    @RequestMapping("getvip")
    @ResponseBody
    public Map<String,Object> getvip(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<Vipdto> pageList =  iUserVipInfoService.findVip(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    @RequestMapping("/vipkind")
    public String vipkind(Model model){
        List<VipKind> vipKinds=iVipKindService.findAll();
        model.addAttribute("vipKinds",vipKinds);
        return "vip/vipkind";
    }

//    @RequestMapping("getvipkind")
//    @ResponseBody
//    public Map<String,Object> getvipkind(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "10") int limit){
//        PageInfo<VipKind> pageList =  iVipKindService.findVipKind(page,limit);
//        Map<String,Object> map =new HashMap<String,Object>();
//        map.put("data",pageList.getList());
//        map.put("count",pageList.getTotal());
//        map.put("code","0");
//        map.put("msg","success");
//        return  map;
//    }

    @RequestMapping(value = "/delete")
    public String delete(long id){
        this.iVipKindService.removeById(id);
        return "redirect:/vip/vipkind";
    }


    @RequestMapping(value = "/addVipKind",method = RequestMethod.GET)
    public String addVipKind(){
        return "vip/addVipKind";
    }

    @RequestMapping(value = "/addVipKind",method = RequestMethod.POST)
    public String addVipKind(VipKind vipKind)
    {

        this.iVipKindService.saveOrUpdate(vipKind);
        return "vip/vipkind";
    }
    @RequestMapping(value = "/editVipKind",method = RequestMethod.GET)
    public String edit(long id, Model model){
        VipKind vipKind=this.iVipKindService.getAllById(id);
        model.addAttribute("vipKind",vipKind);
        return "vip/editVipKind";
    }

    @RequestMapping(value = "/editVipKind",method = RequestMethod.POST)
    public String edit(VipKind vipKind){
        this.iVipKindService.saveOrUpdate(vipKind);
        return "redirect:/vip/vipkind";
    }


    @RequestMapping("/vippay")
    public String vippay(){
        return "vip/vippay";
    }

    @RequestMapping("getvippay")
    @ResponseBody
    public Map<String,Object> getvippay(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<UserVipRecord> pageList =  iUserVipRecordService.findVipRecord(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }
}
