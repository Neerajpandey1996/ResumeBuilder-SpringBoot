package com.neeraj.ResumeBuilderSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.SkillDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.SkillDetail;

@Service
public class SkillDetailDAO 
{
	@Autowired
	SkillDetailRepository skillDetailRepository;

	//save Skill Details
	public SkillDetail saveSkillDetails(SkillDetail details)
	{
		return skillDetailRepository.save(details);
	}
}
