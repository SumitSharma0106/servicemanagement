package com.learn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.app.dto.UpdateIncidentDTO;
import com.learn.app.entity.CommentModel;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Integer>{

	UpdateIncidentDTO save(UpdateIncidentDTO updateIncidentDTO);

}
