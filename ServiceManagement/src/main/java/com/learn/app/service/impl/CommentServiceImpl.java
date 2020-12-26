package com.learn.app.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.dto.UpdateIncidentDTO;
import com.learn.app.entity.CommentModel;
import com.learn.app.entity.CreateIncident;
import com.learn.app.repository.CommentRepository;
import com.learn.app.repository.CreateIncidentRepository;
import com.learn.app.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	CreateIncidentRepository createIncidentRepository;

	@Override
	public UpdateIncidentDTO addComment(String incidentNumber, UpdateIncidentDTO updateIncidentDTO)  {
		
		CreateIncident findByIncidentNumber = createIncidentRepository.findByIncidentNumber(incidentNumber);
		if(findByIncidentNumber !=null) {
			updateIncidentDTO.setCreateIncident(findByIncidentNumber);
			CommentModel commentModel=new CommentModel();
			BeanUtils.copyProperties(updateIncidentDTO, commentModel);
			CommentModel save = commentRepository.save(commentModel);
			UpdateIncidentDTO updateIncidentDTO2=new UpdateIncidentDTO();
			BeanUtils.copyProperties(save, updateIncidentDTO2);
			return updateIncidentDTO2;
			
		}
		return null;
	}

}
