package com.neeraj.ResumeBuilderSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.WorkExprDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.WorkExprDetail;

@Service
public class WorkExprDetailDAO 
{

	@Autowired
	WorkExprDetailRepository workExprDetailRepository;
	
	public WorkExprDetail saveWorkExpr(WorkExprDetail details)
	{
		return workExprDetailRepository.save(details);
	}
	
}
