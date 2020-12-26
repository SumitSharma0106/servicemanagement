package com.learn.app.dto;

import com.learn.app.entity.CreateIncident;

import lombok.Data;

@Data
public class UpdateIncidentDTO {
	
	private Long id;
	private String text;
	private CreateIncident createIncident;

}
