package com.xingyun.national.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Api()用于类名
 * ApiOperation()用于方法名
 * ApiParam()用于参数说明
 * ApiModel()用于实体类
 * ApiModelProperty用于实体类属性
 * ApiImplicitParams({
 *         ApiImplicitParam(name = "page", value = "当前页数1开始",  dataType = "int",paramType = "query"),
 *         ApiImplicitParam(name = "pageSize", value = "每页的大小",  dataType = "int",paramType = "query"),
 *         ApiImplicitParam(name = "userId", value = "当前登录的用户id", dataType = "int",paramType = "query")
 * })
 *
 * paramType：表示参数放在哪个地方
 *     query-->请求参数的获取：@RequestParam(代码中接收注解)
 *     path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
 *     body-->请求参数的获取：@RequestBody(代码中接收注解)
 */
@Configuration
@EnableSwagger2
public class Swagger2  {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("national", "国风社区"),getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xingyun.national.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private Tag[] getTags() {
        return new Tag[]{
                new Tag("advertisement", "广告"),
                new Tag("question", "问题"),
                new Tag("question-click", "问题的点击量"),
                new Tag("question-zan", "问题的赞"),
                new Tag("question-answer", "问题回答"),
                new Tag("answer-reply", "问题回答-追问"),
                new Tag("answer-zan", "问题回答/追问的赞"),
                new Tag("article", "帖子信息"),
                new Tag("article-details", "帖子内容"),
                new Tag("article-click-star", "帖子的点击量"),
                new Tag("article-zan", "帖子赞"),
                new Tag("article-comment", "帖子评论"),
                new Tag("comment-reply", "帖子的评论-回复"),
                new Tag("comment-zan", "帖子评论/回复的赞"),
                new Tag("user-article-collection", "帖子收藏"),
                new Tag("article-report", "帖子内容举报"),
                new Tag("wind", "国风介绍分类"),
                new Tag("wind-details", "国风介绍分类内容"),
                new Tag("notice", "通知公告"),
                new Tag("private-message", "私信"),
                new Tag("tag-info", "标签"),
                new Tag("tag-link-article", "帖子-标签"),
                new Tag("question-link-tag", "问题-标签"),
                new Tag("user", "用户"),
                new Tag("user-coin", "用户金币"),
                new Tag("user-feedback", "用户反馈"),
                new Tag("user-focus", "用户关注"),
                new Tag("user-medal", "用户勋章"),
                new Tag("medal ", "勋章信息"),
                new Tag("user-photo", "用户相册"),
                new Tag("user-photo-collection", "用户相册(原图)"),
                new Tag("user-rank", "用户等级"),
                new Tag("rank", "等级称号"),
                new Tag("user-vip-info", "会员"),
                new Tag("user-vip-record", "会员支付信息"),
                new Tag("vip-kind", "会员等级"),
                new Tag("user-coin-record", "支付金币信息"),
                new Tag("coin-price", "金币价格")

        };
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("maven构建Spring boot项目")
                .description("maven构建Spring boot项目 集成mybatis使用pagehelper插件 ，实现热部署")
                .version("1.0")
                .build();
    }

}
