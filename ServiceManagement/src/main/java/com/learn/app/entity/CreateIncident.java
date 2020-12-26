package com.learn.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.learn.app.hibernateconfig.PrimarySequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "incidents")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateIncident extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inc_seq")
	@GenericGenerator(name = "inc_seq", strategy = "com.learn.app.hibernateconfig.PrimarySequenceGenerator",
	        parameters = {
			@Parameter(name = PrimarySequenceGenerator.VALUE_PREFIX_PARAMETER, value = "INC"),
			@Parameter(name = PrimarySequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%07d") })
	@Column(name = "incident_number", unique = true)
	private String incidentNumber;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false, length = 50)
	private String requestedBy;
	@Column(nullable = false, length = 50)
	private String requestedFor;
	@Column(nullable = false, length = 50)
	private String location;
	@Column(nullable = false, length = 50)
	private String businessService;
	@Column(nullable = false, length = 50)
	private String situation;
	@Column(nullable = false, length = 50)
	private String priority;
	@Column(nullable = false, length = 50)
	private String shortDescription;
	@Column(nullable = false, length = 150)
	private String description;
	@Column(nullable = false, length = 50)
	private String assignmentGroup;
	private String assignedTo;
	@Column(nullable = false, length = 255)
	private String sla;

}
