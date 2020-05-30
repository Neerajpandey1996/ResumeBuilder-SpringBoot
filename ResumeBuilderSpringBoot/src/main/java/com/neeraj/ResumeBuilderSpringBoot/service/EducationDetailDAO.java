package com.neeraj.ResumeBuilderSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.EducationDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.EducationDetail;

@Service
public class EducationDetailDAO 
{

	@Autowired 
	EducationDetailRepository educationDetailRepo;
	
	//Save Education Details
	
	public EducationDetail saveEducationDetails(EducationDetail details)
	{
		return educationDetailRepo.save(details);
	}
}
