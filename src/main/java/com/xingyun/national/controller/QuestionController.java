package com.xingyun.national.controller;


import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.*;
import com.xingyun.national.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
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
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService iQuestionService;

    @Autowired
    private IAnswerReplyService iAnswerReplyService;

    @Autowired
    private IAnswerZanService iAnswerZanService;

    @Autowired
    private IQuestionAnswerService iQuestionAnswerService;

    @Autowired
    private IQuestionClickService iQuestionClickService;

    @Autowired
    private IQuestionZanService iQuestionZanService;



    @RequestMapping("/getQuestion")
    @ResponseBody
    public Map<String,Object> getQueList(@RequestParam(value = "page",defaultValue = "1")int page,
                                         @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<Question> queList =  iQuestionService.findQueList(page,limit);
        Map<String,Object> queMap =new HashMap<String,Object>();
        queMap.put("data",queList.getList());
        queMap.put("count",queList.getTotal());
        queMap.put("code","0");
        queMap.put("msg","success");
        return  queMap;
    }

    @RequestMapping("/questionList")
    public String questionlist(){
        return "question/questionlist";
    }


    @RequestMapping("/getQueAnswer")
    @ResponseBody
    public Map<String,Object> getQueAnswer(@RequestParam(value = "page",defaultValue = "1")int page,
                                        @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<QuestionAnswer> pageList = iQuestionAnswerService.getQuestionAnswers(page,limit);
        Map<String,Object> Map =new HashMap<String,Object>();
        Map.put("data",pageList.getList());
        Map.put("count",pageList.getTotal());
        Map.put("code","0");
        Map.put("msg","success");
        return  Map;
    }


    @RequestMapping("/questionAnswer")
    public String quetionanswer(Model model){
        return "question/questionAnswer";
    }


    @RequestMapping("/getAnswerReply")
    @ResponseBody
    public Map<String,Object> getReplyList(@RequestParam(value = "page",defaultValue = "1")int page,
                                           @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<AnswerReply> replyList =  iAnswerReplyService.getAnswerReplys(page,limit);
        Map<String,Object> Map =new HashMap<String,Object>();
        Map.put("data",replyList.getList());
        Map.put("count",replyList.getTotal());
        Map.put("code","0");
        Map.put("msg","success");
        return  Map;
    }



    @RequestMapping("/answerReply")
    public String answerReply(Model model){
        return "question/answerReply";
    }

    @RequestMapping("/getQuestionZan")
    @ResponseBody
    public Map<String,Object> questionZan(@RequestParam(value = "page",defaultValue = "1")int page,
                                          @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<QuestionZan> pageList =iQuestionZanService.getQuestionZans(page,limit);
        Map<String,Object> Map =new HashMap<String,Object>();
        Map.put("data",pageList.getList());
        Map.put("count",pageList.getTotal());
        Map.put("code","0");
        Map.put("msg","success");
        return  Map;
    }


    @RequestMapping("/questionZan")
    public String questionZan(Model model){
        return "question/questionZan";
    }


    @RequestMapping("/getAnswerZan")
    @ResponseBody
    public Map<String,Object> answerZan(@RequestParam(value = "page",defaultValue = "1")int page,
                                        @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<AnswerZan> pageList = iAnswerZanService.getAnswerZans(page,limit);
        Map<String,Object> Map =new HashMap<String,Object>();
        Map.put("data",pageList.getList());
        Map.put("count",pageList.getTotal());
        Map.put("code","0");
        Map.put("msg","success");
        return  Map;
    }


    @RequestMapping("/answerZan")
    public String answerZan(Model model){
        return "question/answerZan";
    }


    @RequestMapping("/getQuestionClick")
    @ResponseBody
    public Map<String,Object> questionClick(@RequestParam(value = "page",defaultValue = "1")int page,
                                           @RequestParam(value = "limit",defaultValue = "10") int limit){
        PageInfo<QuestionClick> pageList =iQuestionClickService.getQuestionClicks(page,limit);
        Map<String,Object> Map =new HashMap<String,Object>();
        Map.put("data",pageList.getList());
        Map.put("count",pageList.getTotal());
        Map.put("code","0");
        Map.put("msg","success");
        return  Map;
    }


    @RequestMapping("/questionClick")
    public String questionClick(Model model){
        return "question/questionClick";
    }


    @ResponseBody
    @RequestMapping(value = "/activateQuestion/{id}",method = RequestMethod.POST)
    public JsonResult activateQuestion(@PathVariable Integer id)
    {
        try {
            Question question= iQuestionService.getById(id);
            System.out.println("=======================");
            System.out.println(question);
            if (question.getIsDelete() == 1) {
                question.setIsDelete(0);
                iQuestionService.saveOrUpdate(question);
            } else {
                return JsonResult.failure("当前问题已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("激活成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/forbidQuestion/{id}",method = RequestMethod.POST)
    public JsonResult forbidQuestion(@PathVariable Integer id)
    {
        try {
            Question question= iQuestionService.getById(id);
            if (question.getIsDelete() == 0) {
                question.setIsDelete(1);
                iQuestionService.saveOrUpdate(question);
            } else {
                return JsonResult.failure("当前问题已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("禁用成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/answer/activateAnswer/{id}",method = RequestMethod.POST)
    public JsonResult activateAnswer(@PathVariable Integer id)
    {
        try {
            QuestionAnswer queAn= iQuestionAnswerService.getById(id);
            System.out.println("=======================");
            System.out.println(queAn);
            if (queAn.getIsDelete() == 1) {
                queAn.setIsDelete(0);
                iQuestionAnswerService.saveOrUpdate(queAn);
            } else {
                return JsonResult.failure("当前回答已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("激活成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/answer/forbidAnswer/{id}",method = RequestMethod.POST)
    public JsonResult forbidAnswer(@PathVariable Integer id)
    {
        try {
            QuestionAnswer queAn= iQuestionAnswerService.getById(id);
            if (queAn.getIsDelete() == 0) {
                queAn.setIsDelete(1);
                iQuestionAnswerService.saveOrUpdate(queAn);
            } else {
                return JsonResult.failure("当前回答已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("禁用成功！");
    }



    @ResponseBody
    @RequestMapping(value = "/reply/activateAnswer/{id}",method = RequestMethod.POST)
    public JsonResult activateReply(@PathVariable Integer id)
    {
        try {
            AnswerReply answerReply= iAnswerReplyService.getById(id);
            System.out.println("=======================");
            System.out.println(answerReply);
            if (answerReply.getIsDelete() == 1) {
                answerReply.setIsDelete(0);
                iAnswerReplyService.saveOrUpdate(answerReply);
            } else {
                return JsonResult.failure("当前追问已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("激活成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/reply/forbidAnswer/{id}",method = RequestMethod.POST)
    public JsonResult forbidReply(@PathVariable Integer id)
    {
        try {
            AnswerReply answerReply= iAnswerReplyService.getById(id);
            if (answerReply.getIsDelete() == 0) {
                answerReply.setIsDelete(1);
                iAnswerReplyService.saveOrUpdate(answerReply);
            } else {
                return JsonResult.failure("当前追问已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("禁用成功！");
    }


}
