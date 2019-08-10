package com.xingyun.national.controller;


import com.xingyun.national.entity.TagInfo;
import com.xingyun.national.service.ITagInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/tag")
public class TagInfoController {

    @Autowired
    private ITagInfoService iTagInfoService;

    @RequestMapping("/taglist")
    public String taglist(Model model){
         List<TagInfo> tagInfos=iTagInfoService.getTagInfos();
         model.addAttribute("tagInfos",tagInfos);
         return "tag/taglist";
     }

}
