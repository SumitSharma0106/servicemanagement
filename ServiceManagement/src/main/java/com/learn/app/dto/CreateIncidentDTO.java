package com.learn.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreateIncidentDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String incidentNumber;
	private String state;
	private String requestedBy;
	private String requestedFor;
	private String location;
	private String businessService;
	private String situation;
	private String priority;
	private String shortDescription;
	private String description;
	private String assignmentGroup;
	private String assignedTo;
	private String sla;

}
