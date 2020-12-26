package com.learn.app.service;

import com.learn.app.dto.UpdateIncidentDTO;

public interface CommentService {
	
	public UpdateIncidentDTO addComment(String incidentNumber,UpdateIncidentDTO updateIncidentDTO);
	

}
