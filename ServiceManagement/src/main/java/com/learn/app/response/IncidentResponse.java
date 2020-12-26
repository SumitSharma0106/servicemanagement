package com.learn.app.response;

import lombok.Data;

@Data
public class IncidentResponse {

	private String incidentNumber;
	private String requestedBy;
	private String requestedFor;
	private String priority;
	private String shortDescription;
	private String description;
	private String state;
	private String assignmentGroup;
	private String sla;
}
