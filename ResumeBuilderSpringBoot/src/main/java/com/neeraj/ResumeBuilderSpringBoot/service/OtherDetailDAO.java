package com.neeraj.ResumeBuilderSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.OtherDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.OtherDetail;

@Service
public class OtherDetailDAO 
{

	@Autowired 
	OtherDetailRepository otherDetailRepository;
	
	//save Other Details
	
	public OtherDetail saveOtherDetail(OtherDetail details)
	{
		return otherDetailRepository.save(details);
	}
}
