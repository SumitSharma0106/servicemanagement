package com.learn.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.app.dto.UpdateIncidentDTO;
import com.learn.app.request.CommentRequest;
import com.learn.app.response.CommentResponse;
import com.learn.app.service.CommentService;

@RestController
@RequestMapping("comment/v1")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/add/{incidentNumber}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CommentResponse addComment(@PathVariable String incidentNumber,@RequestBody CommentRequest request) {
		CommentResponse commentResponse=new CommentResponse();
		UpdateIncidentDTO dto=new UpdateIncidentDTO();
		BeanUtils.copyProperties(request, dto);
		UpdateIncidentDTO addComment = commentService.addComment(incidentNumber,dto);
		BeanUtils.copyProperties(addComment, commentResponse);
		return commentResponse;
		
	}

}
