package com.learn.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="comments")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel extends AuditModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(nullable = false, length = 250)
	private String text;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="incidentnumber_id",nullable = false)
	@JsonIgnore
	private CreateIncident createIncident;

}
