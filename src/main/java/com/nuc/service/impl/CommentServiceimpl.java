package com.nuc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.bean.Comment;
import com.nuc.mapper.CommentMapper;
import com.nuc.service.CommentService;

@Service
public class CommentServiceimpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public int publishComment(Comment comment) {
		int flag = commentMapper.insertComment(comment);
		return flag;
	}

	@Override
	public List<Comment> getOwnComment(String user_id, String order_id) {
		List<Comment> list = commentMapper.getCommentByid(user_id, order_id);
		return list;
	}

}
