package com.learn.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learn.app.entity.CreateIncident;

@Repository
public interface CreateIncidentRepository extends PagingAndSortingRepository<CreateIncident, String> {

	CreateIncident findByIncidentNumber(String id);

}
