package com.neeraj.ResumeBuilderSpringBoot.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.AddressDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.Repository.EducationDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.Repository.OtherDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.Repository.ProjectDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.Repository.ResumeDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.Repository.SkillDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.Repository.WorkExprDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.ResumeBuilder.Generator;
import com.neeraj.ResumeBuilderSpringBoot.model.AddressDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.EducationDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.OtherDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ProjectDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.SkillDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.WorkExprDetail;

@Service
public class GenerateResumeDAO 
{
	@Autowired
	AddressDetailRepository addressDetailRepository;
	
	@Autowired
	EducationDetailRepository edicationDetailRepository;

	@Autowired
	OtherDetailRepository otherDetailRepository;
	
	@Autowired
	ProjectDetailRepository projectDetailRepository;
	
	@Autowired
	ResumeDetailRepository resumeDetailRepository;
	
	@Autowired
	SkillDetailRepository skillDetailRepository;
	
	@Autowired
	WorkExprDetailRepository workExprDetailRepository;
	
	
	public String getResume(int id) throws IOException
	{
		Generator generate= new Generator();
		ResumeDetail resumeDetail=resumeDetailRepository.findById(id).orElse(null);
		
		//System.out.println("************"+edicationDetailRepository.findByResumeDetailId(id));
		List<EducationDetail> educationDetail=(List<EducationDetail>)edicationDetailRepository.findByResumeDetailId(id);
		List<WorkExprDetail> workExprDetail=(List<WorkExprDetail>)workExprDetailRepository.findByResumeDetailId(id);
		List<SkillDetail> skillDetail=(List<SkillDetail>)skillDetailRepository.findByResumeDetailId(id);
		List<ProjectDetail> projectDetail=(List<ProjectDetail>)projectDetailRepository.findByResumeDetailId(id);
		List<OtherDetail> otherDetail=(List<OtherDetail>)otherDetailRepository.findByResumeDetailId(id);
		
		generate.resumeGenerator(resumeDetail,educationDetail,workExprDetail,skillDetail,projectDetail,otherDetail);
		
		String nameForFile=resumeDetail.getName();
		int idForFile =resumeDetail.getId();
		
		String fileName=nameForFile+idForFile;
		
		
		return fileName;
	}
	
	/*
	public String postResume(int id)
	{
		ResumeDetail resumeDetail=resumeDetailRepository.findById(id).orElse(null);
		
		String nameForFile=resumeDetail.getName();
		int idForFile =resumeDetail.getId();
		
		String fileName=nameForFile+idForFile;
		
		return fileName;
	}  */
}
