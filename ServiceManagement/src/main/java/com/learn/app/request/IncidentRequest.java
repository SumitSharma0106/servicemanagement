package com.learn.app.request;

import lombok.Data;

@Data
public class IncidentRequest {
	
	private String requestedBy;
	private String requestedFor;
	private String location;
	private String businessService;
	private String situation;
	private String priority;
	private String shortDescription;
	private String description;
	private String state;
	private String assignmentGroup;

}
