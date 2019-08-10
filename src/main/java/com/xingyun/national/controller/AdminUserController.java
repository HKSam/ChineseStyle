package com.xingyun.national.controller;



import com.xingyun.national.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-07
 */
@Controller
//@RequestMapping("/admin")
public class AdminUserController {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private IArticleService iArticleService;

    @Autowired
    private IActivityService iActivityService;

    @Autowired
    private IWindService iWindService;

    @Autowired
    private IUserVipInfoService iUserVipInfoService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    /**
     * 通过model传输统计的数据
     */
    public void datamodel(Model model){
        long usernum=this.iUserService.countUser();
        long articlenum=this.iArticleService.countACAll();
        long activitynum=this.iActivityService.countActivity();
        long windunm=this.iWindService.countWind();
        long vipnum=this.iUserVipInfoService.countVip();
        model.addAttribute("usernum",usernum);
        model.addAttribute("articlenum",articlenum);
        model.addAttribute("activitynum",activitynum);
        model.addAttribute("windunm",windunm);
        model.addAttribute("vipnum",vipnum);
    }

    @ApiOperation("返回我的桌面")
    @RequestMapping("/welcome")
    public String welcome(Model model){
        datamodel(model);
        return "welcome";
    }


    @RequestMapping("/welcome1")
    public String welcome1(Model model){
        datamodel(model);
        return "welcome1";
    }



}
