package com.nuc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nuc.bean.Comment;

public interface CommentMapper {
	int insertComment(Comment comment);
   List<Comment> getCommentByid(@Param("user_id")String user_id,@Param("order_id")String order_id);
}
