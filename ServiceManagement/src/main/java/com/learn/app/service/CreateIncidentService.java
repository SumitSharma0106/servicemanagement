package com.learn.app.service;

import java.util.List;

import com.learn.app.dto.CreateIncidentDTO;

public interface CreateIncidentService {

	public CreateIncidentDTO createIncident(CreateIncidentDTO createIncident);

	public CreateIncidentDTO getIncident(String incidentNumber);

	public CreateIncidentDTO updateIncident(String incidentNumber, CreateIncidentDTO createIncident);
	
	public List<CreateIncidentDTO> getIncidents(int page,int size);

}
