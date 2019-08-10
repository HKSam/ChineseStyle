package com.xingyun.national.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.common.ResultGenerator;
import com.xingyun.national.dto.Userdto;
import com.xingyun.national.entity.User;
import com.xingyun.national.entity.UserCoin;
import com.xingyun.national.entity.UserFeedback;
import com.xingyun.national.service.IUserCoinService;
import com.xingyun.national.service.IUserFeedbackService;
import com.xingyun.national.service.IUserService;
import com.xingyun.national.service.specification.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserCoinService iUserCoinService;

    @Autowired
    private IUserFeedbackService iUserFeedbackService;

//    @RequestMapping("/list")
//    public String list(Model model) {
//        List<User> users=this.iUserService.getUsers();
//        model.addAttribute("userlist",users);
//        return "user/list";
//    }

    @RequestMapping("/list")
    public String list(Model model){
        List<User> users=this.iUserService.getUsers();
        model.addAttribute("userlist",users);
        return "user/list";
    }

    /**
     *
     * 分页查询列表
     * @return ok/fail
     */
    @ResponseBody
    @RequestMapping("findNickName")
    public Map<String,Object> getUserByName(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "limit",defaultValue = "10") int limit, String nickName){

        PageInfo<User> pageList =  iUserService.getAllByName(page,limit,nickName);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     *
     * 分页查询用户
     *
     */
    @RequestMapping("getUser")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<Userdto> pageList =  iUserService.findUser(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     *
     * 根据id删除
     *
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public JsonResult delete(@PathVariable long id){
        this.iUserService.deleteUser(id);
        return JsonResult.success("删除成功");
    }


    @ResponseBody
    @RequestMapping(value = "/deleteFeedBack/{id}",method = RequestMethod.POST)
    public JsonResult deleteFeedBack(@PathVariable long id){
        this.iUserFeedbackService.removeById(id);
        return JsonResult.success("删除成功");
    }


    @ResponseBody
    @RequestMapping(value = "/deleteCoin/{id}",method = RequestMethod.POST)
    public JsonResult deleteCoin(@PathVariable long id){
        this.iUserCoinService.removeById(id);
        return JsonResult.success("删除成功");
    }

    /**
     *
     * 编辑
     *
     */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(long id, Model model){
        User user=this.iUserService.getUser(id);
        model.addAttribute("user",user);
        return "user/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(User user){
        this.iUserService.updateUser(user);
        return "redirect:/user/list";
    }

    /**
     *
     * 返回用户金币列表
     *
     */
    @RequestMapping(value="/userCoin")
    public String userCoin(Model model){
        List<UserCoin> userCoins=iUserCoinService.getUserCoins();
        model.addAttribute("userCoins",userCoins);

        return "user/userCoin";
    }

    @RequestMapping("getCoin")
    @ResponseBody
    public Map<String,Object> getCoin(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<UserCoin> pageList =  iUserCoinService.findUserCoins(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    @RequestMapping(value="/userFeedBack")
    public String userFeedBack(Model model){
        List<UserFeedback> userFeedBacks=iUserFeedbackService.getUserFeedBacks();
        model.addAttribute("userFeedBacks",userFeedBacks);
        return "user/userFeedBack";
    }

//    public Map<String,Object> layuiPage(List a,long b){
//        Map<String,Object> map =new HashMap<String,Object>();
//        map.put("data",a);
//        map.put("count",b);
//        map.put("code","0");
//        map.put("msg","success");
//        return map;
//    }

    @RequestMapping("getFeedBack")
    @ResponseBody
    public Map<String,Object> getFeedBack(@RequestParam(value = "page",defaultValue = "1")int page,@RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<UserFeedback> pageList =  iUserFeedbackService.findFeedBack(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return map;
    }

    /**
     *
     * 激活
     *
     */
    @ResponseBody
    @RequestMapping(value = "/activate/{id}",method = RequestMethod.POST)
    public JsonResult activate(@PathVariable Integer id){
        try {

            User user = iUserService.getUser(id);
            if (user.getStatus() == 0) {
                user.setStatus(1);
                iUserService.saveOrUpdate(user);
            } else {
                return JsonResult.failure("该用户已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("激活成功！");

    }

    /**
     *
     * 禁用
     *
     */
    @ResponseBody
    @RequestMapping(value = "/forbid/{id}", method = RequestMethod.POST)
    public JsonResult forbid(@PathVariable Integer id)
    {
        try {

            User user = iUserService.getUser(id);
            if (user.getStatus() == 1) {
                user.setStatus(0);
                iUserService.saveOrUpdate(user);

            } else {
                return JsonResult.failure("该用户已禁用");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁用成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/activateFeedBack/{id}",method = RequestMethod.POST)
    public JsonResult activateFeedBack(@PathVariable Integer id){
        try {

            UserFeedback userFeedback = iUserFeedbackService.getUserFeedBackById(id);
            if (userFeedback.getStatus() == 0) {
                userFeedback.setStatus(1);
                iUserFeedbackService.saveOrUpdate(userFeedback);
            } else {
                return JsonResult.failure("该反馈已审核！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("已审核！");

    }


//    @ResponseBody
//    @RequestMapping(value = "/forbidFeedBack/{id}", method = RequestMethod.POST)
//    public JsonResult forbidFeedBack(@PathVariable Integer id)
//    {
//        try {
//
//            User user = iUserService.getUser(id);
//            if (user.getStatus() == 1) {
//                user.setStatus(0);
//                iUserService.saveOrUpdate(user);
//
//            } else {
//                return JsonResult.failure("该反馈未审核");
//            }
//        }catch (Exception ex)
//        {
//            ex.printStackTrace();
//
//        }
//        return JsonResult.success("未审核！");
//    }

    /**
     * 根据用户名查询
     */

}
