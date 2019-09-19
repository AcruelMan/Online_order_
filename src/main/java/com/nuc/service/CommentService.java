package com.nuc.service;

import java.util.List;

import com.nuc.bean.Comment;

public interface CommentService {
 int publishComment(Comment comment);
 List<Comment> getOwnComment(String user_id,String order_id);
}
