package com.learn.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learn.app.constant.SLAConstant;
import com.learn.app.dto.CreateIncidentDTO;
import com.learn.app.entity.CreateIncident;
import com.learn.app.exception.NotFoundException;
import com.learn.app.repository.CreateIncidentRepository;
import com.learn.app.service.CreateIncidentService;
import com.learn.app.service.EmailService;

@Service
public class CreateIncidentServiceImpl implements CreateIncidentService {

	@Autowired
	CreateIncidentRepository createIncidentRepository;

	@Autowired
	EmailService emailService;

	@Override
	public CreateIncidentDTO createIncident(CreateIncidentDTO createIncident) {
		CreateIncident creIncident = new CreateIncident();
		BeanUtils.copyProperties(createIncident, creIncident);
		createSlaTracker(creIncident);
		CreateIncident storedDetails = createIncidentRepository.save(creIncident);
		emailSend(storedDetails);
		CreateIncidentDTO returnValue = new CreateIncidentDTO();
		BeanUtils.copyProperties(storedDetails, returnValue);
		return returnValue;
	}

	@Override
	public CreateIncidentDTO getIncident(String incidentNumber) {
		CreateIncidentDTO returnValue = new CreateIncidentDTO();
		CreateIncident fetchIncident = createIncidentRepository.findByIncidentNumber(incidentNumber);
		if (fetchIncident == null)
			throw new NotFoundException(incidentNumber);
		BeanUtils.copyProperties(fetchIncident, returnValue);
		return returnValue;
	}

	@Override
	public CreateIncidentDTO updateIncident(String incidentNumber, CreateIncidentDTO createIncident) {
		CreateIncident creIncident = createIncidentRepository.findByIncidentNumber(incidentNumber);
		if (creIncident == null)
			throw new NotFoundException(incidentNumber);
		CreateIncidentDTO returnValue = new CreateIncidentDTO();
		creIncident.setState(createIncident.getState());
		creIncident.setBusinessService(createIncident.getBusinessService());
		creIncident.setSituation(createIncident.getSituation());
		creIncident.setPriority(createIncident.getPriority());
		creIncident.setShortDescription(createIncident.getShortDescription());
		creIncident.setDescription(createIncident.getDescription());
		creIncident.setAssignmentGroup(createIncident.getAssignmentGroup());
		createSlaTracker(creIncident);
		CreateIncident updatedIncidentDetails = createIncidentRepository.save(creIncident);
		BeanUtils.copyProperties(updatedIncidentDetails, returnValue);
		return returnValue;
	}

	@Override
	public List<CreateIncidentDTO> getIncidents(int page, int size) {
		List<CreateIncidentDTO> creatIncidentDTOs = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, size);
		Page<CreateIncident> users = createIncidentRepository.findAll(pageableRequest);
		List<CreateIncident> user = users.getContent();
		for (CreateIncident createIncident : user) {
			CreateIncidentDTO dto = new CreateIncidentDTO();
			BeanUtils.copyProperties(createIncident, dto);
			creatIncidentDTOs.add(dto);
		}
		return creatIncidentDTOs;
	}

	private void createSlaTracker(CreateIncident creIncident) {
		if (creIncident.getPriority().equalsIgnoreCase("P4")) {
			creIncident.setSla(SLAConstant.P4);
		} else if (creIncident.getPriority().equalsIgnoreCase("P3")) {
			creIncident.setSla(SLAConstant.P3);
		} else if (creIncident.getPriority().equalsIgnoreCase("P2")) {
			creIncident.setSla(SLAConstant.P2);
		} else
			creIncident.setSla(SLAConstant.P1);
	}

	private void emailSend(CreateIncident storedDetails) {
		if (storedDetails.getIncidentNumber() != null && storedDetails.getState().equalsIgnoreCase("New")) {
			emailService.sendEmail("Incident " + storedDetails.getIncidentNumber() + " has been opened for you",
					"To " + storedDetails.getRequestedFor() + " ," + "\n" + "\n" +
					storedDetails.getIncidentNumber() + " - " + storedDetails.getDescription()
					+ "\n" + "\n" + "\n" +
					"Your incident has been created and we are currently working to address your query. Please utilize the link below to view the current status or add additional comments."
					+ "\n" + "\n" +
					"Thank you," + "\n" +
					"Service Desk",
					storedDetails.getRequestedBy(), storedDetails.getRequestedFor());
		}
	}

}
