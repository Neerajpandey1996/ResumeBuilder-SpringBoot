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

import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.WorkExprDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;
import com.neeraj.ResumeBuilderSpringBoot.service.WorkExprDetailDAO;

@RestController
@CrossOrigin(origins="*")
public class WorkExprDetailController 
{
	@Autowired
	ResumeDetailDAO resumeDetailDao;
	
	@Autowired
	WorkExprDetailDAO workExprDetailDao;
	
	@PostMapping("/WorkExpr/{id}")
	public ResponseEntity<WorkExprDetail> saveWorkExprDetail(@Valid @PathVariable("id") int resumeDetailid ,@Valid @RequestBody WorkExprDetail workExprDatail) throws Exception
	{
		System.out.println(workExprDatail.getDiscription());
		ResumeDetail resumeDetail=resumeDetailDao.findByResumeId(resumeDetailid);
		if(resumeDetail==null)
		{
			 throw new Exception();
		}
		
		WorkExprDetail newWorkExprDetail=new WorkExprDetail();
		
		newWorkExprDetail.setResumeDetail(resumeDetail);
		newWorkExprDetail.setDiscription(workExprDatail.getDiscription());
		newWorkExprDetail.setFromYear(workExprDatail.getFromYear());
		newWorkExprDetail.setOrgName(workExprDatail.getOrgName());
		newWorkExprDetail.setRole(workExprDatail.getRole());
		newWorkExprDetail.setToYear(workExprDatail.getToYear());
		
		WorkExprDetail copyWorkExprDetail=workExprDetailDao.saveWorkExpr(newWorkExprDetail);
		
		if(copyWorkExprDetail==null)
		{
			throw new Exception();
		}
		
		return new ResponseEntity<WorkExprDetail>(copyWorkExprDetail,HttpStatus.OK) ;
		
		
	}
}
