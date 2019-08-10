package com.xingyun.national.controller;


import com.github.pagehelper.PageInfo;
import com.xingyun.national.common.JsonResult;
import com.xingyun.national.entity.*;
import com.xingyun.national.service.*;
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
 *  前端控制器
 * </p>
 *
 * @author CYS
 * @since 2019-07-09
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;

    @Autowired
    private IArticleClickStatService iArticleClickStatService;

    @Autowired
    private IArticleCommentService iArticleCommentService;

    @Autowired
    private IArticleDetailsService iArticleDetailsService;

    @Autowired
    private IArticleReportService iArticleReportService;

    @Autowired
    private IArticleZanService iArticleZanService;

    @Autowired
    private ICommentReplyService iCommentReplyService;

    @Autowired
    private ICommentZanService iCommentZanService;

    /**
     * 返回帖子列表
     */
    @ApiOperation("返回帖子列表")
    @RequestMapping("/articlelist")
    public String articlelist(Model model){
        List<Article> articles=iArticleService.getArticles();
        model.addAttribute("articles",articles);
        return "article/articlelist";
    }

    /**
     * 分页查询帖子
     */
    @ApiOperation("分页查询帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "5"),
    })
    @RequestMapping(value = "/getArticle")
    @ResponseBody
    public Map<String,Object> getArticle(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<Article> pageList =  iArticleService.findArticle(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     * 根据id删除帖子
     */
    @ApiOperation("根据id删除帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/deleteArticle/{id}",method = RequestMethod.POST)
    public JsonResult delete(@PathVariable Integer id){
        this.iArticleService.removeById(id);
        return JsonResult.success("删除成功！");
    }

    /**
     * 激活帖子
     */
    @ApiOperation("激活帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/activateArticle/{id}",method = RequestMethod.POST)
    public JsonResult activateArticle(@PathVariable Integer id)
    {
        try {
            Article article = iArticleService.getArticleById(id);
            if (article.getIsDelete() == 1) {
                article.setIsDelete(0);
                iArticleService.saveOrUpdate(article);
            } else {
                return JsonResult.failure("当前帖子已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("激活成功！");
    }

    /**
     * 禁用帖子
     */
    @ApiOperation("禁用帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/forbidArticle/{id}",method = RequestMethod.POST)
    public JsonResult forbidArticle(@PathVariable Integer id)
    {
        try {
            Article article = iArticleService.getArticleById(id);
            if (article.getIsDelete() == 0) {
                article.setIsDelete(1);
                iArticleService.saveOrUpdate(article);

            } else {
                return JsonResult.failure("当前帖子已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return JsonResult.success("禁用成功！");
    }

    /**
     * 帖子点击量
     */
    @ApiOperation("帖子点击量")
    @RequestMapping("/articleClickStat")
    public String articleClickStat(Model model){
        List<ArticleClickStat> articleClickStats=iArticleClickStatService.getArticlesClickStat();
        model.addAttribute("articleClickStats",articleClickStats);
        return "article/articleClickStat";
    }

    /**
     * 分页查询帖子点击量
     */
    @ApiOperation("分页查询帖子点击量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "5"),
    })
    @RequestMapping("getClickStat")
    @ResponseBody
    public Map<String,Object> getClickStat(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<ArticleClickStat> pageList =  iArticleClickStatService.findArticleClickStat(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    /**
     * 帖子评论
     */
    @RequestMapping("/articleComment")
    public String articleComment(Model model){
        List<ArticleComment> articleComments=iArticleCommentService.getArticleComments();
        model.addAttribute("articleComments",articleComments);
        return "article/articleComment";
    }

    @ApiOperation("分页查询帖子评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "5"),
    })
    @RequestMapping("getac")
    @ResponseBody
    public Map<String,Object> getac(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<ArticleComment> pageList =  iArticleCommentService.findAC(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    @ApiOperation("删除帖子评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子评论自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/deleteAC/{id}",method = RequestMethod.POST)
    public JsonResult deleteAC(@PathVariable Integer id){
        this.iArticleCommentService.removeById(id);
        return JsonResult.success("删除成功！");
    }

    @ApiOperation("激活帖子评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子评论自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/activateAC/{id}",method = RequestMethod.POST)
    public JsonResult activateAC(@PathVariable Integer id)
    {
        try {

            ArticleComment articleComment = iArticleCommentService.findAcById(id);
            if (articleComment.getIsDelete() == 1) {
                articleComment.setIsDelete(0);
                iArticleCommentService.saveOrUpdate(articleComment);

            } else {
                return JsonResult.failure("当前评论详情已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("激活成功！");
    }

    @ApiOperation("禁用帖子评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子评论自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/forbidAC/{id}",method = RequestMethod.POST)
    public JsonResult forbidAC(@PathVariable Integer id)
    {
        try {

            ArticleComment articleComment = iArticleCommentService.findAcById(id);
            if (articleComment.getIsDelete() == 0) {
                articleComment.setIsDelete(1);
                iArticleCommentService.saveOrUpdate(articleComment);

            } else {
                return JsonResult.failure("当前评论详情已禁止！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁止成功！");
    }

    @RequestMapping("/articleDetails")
    public String articleDetails(Model model){
        List<ArticleDetails> articleDetails=iArticleDetailsService.getArticleDetails();
        model.addAttribute("articleDetails",articleDetails);
        return "article/articleDetails";
    }

    @ApiOperation("分页查询帖子详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数1开始", defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value = "每页的大小",  defaultValue = "5"),
    })
    @RequestMapping("getArticleDetails")
    @ResponseBody
    public Map<String,Object> getArticleDetails(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<ArticleDetails> pageList =  iArticleDetailsService.findAticleDetails(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }


    @ApiOperation("删除帖子详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子详情自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/deleteArticleDetails/{id}",method = RequestMethod.POST)
    public JsonResult deleteArticleDetails(@PathVariable Integer id){
        this.iArticleDetailsService.removeById(id);
        return JsonResult.success("删除成功！");
    }


    @ApiOperation("激活帖子详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子详情自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/activateArticleDetails/{id}",method = RequestMethod.POST)
    public JsonResult activateArticleDetails(@PathVariable Integer id)
    {
        try {

            ArticleDetails articleDetails = iArticleDetailsService.getArticleDetailById(id);
            if (articleDetails.getIsDelete() == 1) {
                articleDetails.setIsDelete(0);
                iArticleDetailsService.saveOrUpdate(articleDetails);

            } else {
                return JsonResult.failure("当前帖子详情已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("激活成功！");
    }

    @ApiOperation("禁用帖子详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子详情自增id"),
    })
    @ResponseBody
    @RequestMapping(value = "/forbidArticleDetails/{id}",method = RequestMethod.POST)
    public JsonResult forbidArticleDetails(@PathVariable Integer id)
    {
        try {

            ArticleDetails articleDetails = iArticleDetailsService.getArticleDetailById(id);
            if (articleDetails.getIsDelete() == 0) {
                articleDetails.setIsDelete(1);
                iArticleDetailsService.saveOrUpdate(articleDetails);

            } else {
                return JsonResult.failure("当前帖子详情已禁用！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁用成功！");
    }

    @RequestMapping("/articleReport")
    public String articleReport(Model model){
        List<ArticleReport> articleReports=iArticleReportService.getArticleReports();
        model.addAttribute("articleReports",articleReports);
        return "article/articleReport";
    }

    @RequestMapping("getArticleReport")
    @ResponseBody
    public Map<String,Object> getArticleReport(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<ArticleReport> pageList =  iArticleReportService.findArticleReport(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    @ResponseBody
    @RequestMapping(value = "/activateReport/{id}",method = RequestMethod.POST)
    public JsonResult activateReport(@PathVariable Integer id)
    {
        try {

            ArticleReport articleReport = iArticleReportService.getReportById(id);
            if (articleReport.getStatus() == 0) {
                articleReport.setStatus(1);
                iArticleReportService.saveOrUpdate(articleReport);

            } else {
                return JsonResult.failure("已审核！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("审核成功！");
    }

    @RequestMapping("/articleZan")
    public String articleZan(Model model){
        List<ArticleZan> articles=iArticleZanService.getArticleZans();
        model.addAttribute("articles",articles);
        return "article/articleZan";
    }

    @RequestMapping("getArticleZan")
    @ResponseBody
    public Map<String,Object> getArticleZan(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<ArticleZan> pageList =  iArticleZanService.findArticleZan(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }

    @RequestMapping("/articleReply")
    public String commentReply(Model model){
        List<CommentReply>  commentReplies= iCommentReplyService.getCommentReplys();
        model.addAttribute("commentReplies",commentReplies);
        return "article/articleReply";
    }

    @RequestMapping("getreply")
    @ResponseBody
    public Map<String,Object> getreply(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<CommentReply> pageList =  iCommentReplyService.findReply(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteReply/{id}",method = RequestMethod.POST)
    public JsonResult deleteReply(@PathVariable Integer id){
        this.iCommentReplyService.removeById(id);
        return JsonResult.success("删除成功！");
    }


    @ResponseBody
    @RequestMapping(value = "/activateReply/{id}",method = RequestMethod.POST)
    public JsonResult activateReply(@PathVariable Integer id)
    {
        try {

            CommentReply commentReply =iCommentReplyService.getReplyById(id);
            if (commentReply.getIsDelete() == 1) {
                commentReply.setIsDelete(0);
                iCommentReplyService.saveOrUpdate(commentReply);

            } else {
                return JsonResult.failure("当前评论回复已激活！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("激活成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/forbidReply/{id}",method = RequestMethod.POST)
    public JsonResult forbidReply(@PathVariable Integer id)
    {
        try {

            CommentReply commentReply =iCommentReplyService.getReplyById(id);
            if (commentReply.getIsDelete() == 0) {
                commentReply.setIsDelete(1);
                iCommentReplyService.saveOrUpdate(commentReply);

            } else {
                return JsonResult.failure("当前评论回复已禁止！");
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();

        }
        return JsonResult.success("禁止成功！");
    }



    @RequestMapping("/commentZan")
    public String commentZan(Model model){
        List<CommentZan> commentZans=iCommentZanService.getCommentZans();
        model.addAttribute("commentZans",commentZans);
        return "article/commentZan";
    }


    @RequestMapping("getCommentZan")
    @ResponseBody
    public Map<String,Object> getCommentZan(@RequestParam(value = "page",defaultValue = "1")int page, @RequestParam(value = "limit",defaultValue = "5") int limit){
        PageInfo<CommentZan> pageList =  iCommentZanService.findCommentZan(page,limit);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("data",pageList.getList());
        map.put("count",pageList.getTotal());
        map.put("code","0");
        map.put("msg","success");
        return  map;
    }
}
