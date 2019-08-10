package com.xingyun.national.mapper;

import com.xingyun.national.entity.ArticleZan;
import com.xingyun.national.entity.CommentReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CYS
 * @since 2019-07-10
 */
@Component
public interface CommentReplyMapper extends BaseMapper<CommentReply> {


    @Select("select id as id," +
            "user_id as user_id," +
            "comment_id as comment_id," +
            "article_id as article_id," +
            "content as content," +
            "is_delete as is_delete,"+
            "create_time as create_time," +
            "update_time as update_time from comment_reply")
    public List<CommentReply> findAll();

    @Select("select * from comment_reply where id=#{id}")
    public CommentReply findAllById(long id);
}
