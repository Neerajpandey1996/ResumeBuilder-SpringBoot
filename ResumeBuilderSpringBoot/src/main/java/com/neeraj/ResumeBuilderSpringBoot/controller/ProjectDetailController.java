package com.neeraj.ResumeBuilderSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neeraj.ResumeBuilderSpringBoot.model.ProjectDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.ProjectDetailDAO;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;

@RestController
@CrossOrigin(origins="*")
public class ProjectDetailController 
{
	@Autowired
	ResumeDetailDAO resumeDetailDao;
	
	@Autowired
	ProjectDetailDAO projectDetailDao;
	
	//Save Project Detail
	@PostMapping("/project/{id}")
	public ResponseEntity<ProjectDetail> saveOtherDetail(@Valid @PathVariable("id") int resumeDetailid ,@Valid @RequestBody ProjectDetail projectDatail) throws Exception
	{
		ResumeDetail resumeDetail=resumeDetailDao.findByResumeId(resumeDetailid);
		if(resumeDetail==null)
		{
			 throw new Exception();
		}
		
		ProjectDetail newProjectDetail=new ProjectDetail();
		
		newProjectDetail.setResumeDetail(resumeDetail);
		newProjectDetail.setProjectDiscription(projectDatail.getProjectDiscription());
		newProjectDetail.setProjectName(projectDatail.getProjectName());
		newProjectDetail.setYear(projectDatail.getYear());
	
		ProjectDetail copyProjectDetail= projectDetailDao.saveProjectDetail(newProjectDetail);
		if(copyProjectDetail==null)
		{
			throw new Exception();
		}
		
		return new ResponseEntity<ProjectDetail>(copyProjectDetail,HttpStatus.OK);
	}
}
