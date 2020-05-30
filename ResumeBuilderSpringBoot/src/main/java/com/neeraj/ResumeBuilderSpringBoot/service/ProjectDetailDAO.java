package com.neeraj.ResumeBuilderSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.ProjectDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.ProjectDetail;

@Service
public class ProjectDetailDAO 
{

	@Autowired
	ProjectDetailRepository projectDetailRepository;
	
	//save ProjectDetail
	
	public ProjectDetail saveProjectDetail(ProjectDetail detail)
	{
		return projectDetailRepository.save(detail);
	}
}
