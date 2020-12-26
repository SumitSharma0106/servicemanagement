package com.learn.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.app.dto.CreateIncidentDTO;
import com.learn.app.request.IncidentRequest;
import com.learn.app.response.IncidentResponse;
import com.learn.app.service.CreateIncidentService;

@RestController
@RequestMapping("incident/v1")
public class IncidentController {

	@Autowired
	CreateIncidentService createIncidentService;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public IncidentResponse createIncident(@RequestBody IncidentRequest request) {
		IncidentResponse returnValue = new IncidentResponse();
		CreateIncidentDTO dto = new CreateIncidentDTO();
		BeanUtils.copyProperties(request, dto);
		CreateIncidentDTO createdIncident = createIncidentService.createIncident(dto);
		BeanUtils.copyProperties(createdIncident, returnValue);
		return returnValue;
	}

	@GetMapping("/{incidentNumber}")
	public IncidentResponse getIncident(@PathVariable String incidentNumber) {
		IncidentResponse returnValue = new IncidentResponse();
		CreateIncidentDTO returnedIncident = createIncidentService.getIncident(incidentNumber);
		BeanUtils.copyProperties(returnedIncident, returnValue);
		return returnValue;

	}

	@PutMapping("/update/{incidentNumber}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public IncidentResponse updateIncident(@PathVariable String incidentNumber,
			@RequestBody IncidentRequest createIncident) {
		IncidentResponse returnValue = new IncidentResponse();
		CreateIncidentDTO dto = new CreateIncidentDTO();
		BeanUtils.copyProperties(createIncident, dto);
		CreateIncidentDTO updatedIncident = createIncidentService.updateIncident(incidentNumber, dto);
		BeanUtils.copyProperties(updatedIncident, returnValue);
		return returnValue;
	}
	
	@GetMapping
	public List<IncidentResponse> getIncidents(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "2") int size){
		List<IncidentResponse> returnValue=new ArrayList<IncidentResponse>();
		List<CreateIncidentDTO> incidentDto=createIncidentService.getIncidents(page, size);
		for(CreateIncidentDTO dto:incidentDto) {
			IncidentResponse response = new IncidentResponse();
			BeanUtils.copyProperties(dto, response);
			returnValue.add(response);
		}
		return returnValue;
		
	}
	

}
