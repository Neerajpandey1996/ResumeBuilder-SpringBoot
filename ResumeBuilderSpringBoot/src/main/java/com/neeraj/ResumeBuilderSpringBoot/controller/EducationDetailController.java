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

import com.neeraj.ResumeBuilderSpringBoot.model.EducationDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.EducationDetailDAO;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;

@RestController
@CrossOrigin(origins="*")
public class EducationDetailController 
{
	@Autowired
	ResumeDetailDAO resumeDetailDao;
	
	@Autowired
	EducationDetailDAO educationDetailDao;
	
	//save Education Details
	@PostMapping("/EducationDetail/{id}")
	public ResponseEntity<EducationDetail> saveEducationDetail(@Valid @PathVariable("id") int resumeDetailId , @Valid @RequestBody EducationDetail educationDetail) throws Exception
	{
	ResumeDetail resumeDetail=resumeDetailDao.findByResumeId(resumeDetailId);
	
	if(resumeDetail==null)
	{
		throw new Exception();
	}
	
	EducationDetail newEducationDetail=new EducationDetail();
	
	newEducationDetail.setResumeDetail(resumeDetail);
	newEducationDetail.setCourseName(educationDetail.getCourseName());
	newEducationDetail.setPercentage(educationDetail.getPercentage());
	newEducationDetail.setSchoolName(educationDetail.getSchoolName());
	newEducationDetail.setYearOfPassing(educationDetail.getYearOfPassing());
	
	EducationDetail copyEducationDetail=educationDetailDao.saveEducationDetails(newEducationDetail);
	
	if(copyEducationDetail==null)
	{
		throw new Exception();
	}
	
	return new ResponseEntity<EducationDetail>(copyEducationDetail,HttpStatus.OK);
	
	}
}
