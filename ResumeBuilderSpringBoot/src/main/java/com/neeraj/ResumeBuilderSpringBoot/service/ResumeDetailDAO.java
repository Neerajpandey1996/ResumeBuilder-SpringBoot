package com.neeraj.ResumeBuilderSpringBoot.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.ResumeDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;

@Service 
public class ResumeDetailDAO 
{

	@Autowired
	ResumeDetailRepository repo;
	
	
	//Save Resume details in database (ResumeBuilder->ResumeDetails)
   
	public ResumeDetail saveResumeDetail(ResumeDetail details)
	{
		return repo.save(details);
	}

	//Find by Resume Id
	
	public ResumeDetail findByResumeId(int id)
	{
		return repo.findById(id).orElse(null);
	}
}
