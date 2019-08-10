package com.xingyun.national.controller;

import com.xingyun.national.entity.AdminUser;
import com.xingyun.national.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-07
 */
@Controller
public class LoginController {

    @Autowired
    IAdminUserService iAdminUserService;

    /**
     * 打开登录表单
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    /**
     * 登录验证
     */
//    @RequestMapping(value={"/login"},method = RequestMethod.POST)
//    public String login(@RequestParam("password")String password,@RequestParam("name")String name){
//        if(name==null){
//            return "login";
//        }
//        String realpwd=iAdminUserService.getpwdbyname(name);
//        if(realpwd!=null&&password.equals(realpwd)){
//            return "index";
//        }
//        else
//            return "login";
//    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    protected String login(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        AdminUser user = this.iAdminUserService.login(name, password);

        if(user==null)
        {
            model.addAttribute("msg", "用户名或者密码错误");
            return "/login";
        }
        else{
            request.getSession().setAttribute("user", user);
            return "redirect:/index";
        }

    }

    /**
     * 登出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "login";
    }


}
