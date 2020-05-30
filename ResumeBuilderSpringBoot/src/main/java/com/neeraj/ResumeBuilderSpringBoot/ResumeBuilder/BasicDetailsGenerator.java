package com.neeraj.ResumeBuilderSpringBoot.ResumeBuilder;

import java.util.ArrayList;
import java.util.List;

import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;

public class BasicDetailsGenerator 
{
	public List<String> headerDetail(ResumeDetail resumeDetail)
	{
	
		List<String> heading=new ArrayList<String>();
		
		if(!resumeDetail.getName().isEmpty())
		{
			heading.add(resumeDetail.getName());
		}
		
		if(!resumeDetail.getMobile().isEmpty())
		{
			heading.add(resumeDetail.getMobile());
		}
		
		if(!resumeDetail.getEmail().isEmpty())
		{
			heading.add(resumeDetail.getEmail());
		}
		
		if(resumeDetail.getLinkdinId()==null)
		{
			
			heading.add(resumeDetail.getLinkdinId());
		}
	
		if(resumeDetail.getLinkdinId()!=null)
		{
			
			heading.add("LinkedinId : "+resumeDetail.getLinkdinId());
		}
		
		
		if(resumeDetail.getGitId()==null)
		{
			heading.add(resumeDetail.getGitId());
		}
	
		if(resumeDetail.getGitId()!=null)
		{
			heading.add("GitId : "+resumeDetail.getGitId());
		}
		
		
		
		if(resumeDetail.getDeclaration()==null)
		{
			heading.add(resumeDetail.getDeclaration());
		}
		if(resumeDetail.getDeclaration()!=null)
		{
			heading.add(resumeDetail.getDeclaration());
		}
		
		
		
		return heading;
	}
	

}
