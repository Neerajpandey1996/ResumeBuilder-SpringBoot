package com.neeraj.ResumeBuilderSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;

@RestController
@CrossOrigin("*")
public class ResumeDetailController 
{
	@Autowired
	ResumeDetailDAO resumeDetailDao;

	@PostMapping("/BasicDetails")
	public ResponseEntity<ResumeDetail> saveBasicDetails(@Valid @RequestBody ResumeDetail resumeDetail) throws Exception
	{
		System.out.println(resumeDetail.getGitId());
	   ResumeDetail copyResumeDetail=resumeDetailDao.saveResumeDetail(resumeDetail);
	   if(copyResumeDetail==null)
	   {
		   throw new Exception();
	   }
	   
	   return new ResponseEntity<ResumeDetail>(copyResumeDetail,HttpStatus.OK);
	   
	}
}
