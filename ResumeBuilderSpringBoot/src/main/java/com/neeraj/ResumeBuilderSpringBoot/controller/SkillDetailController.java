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
import com.neeraj.ResumeBuilderSpringBoot.model.SkillDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;
import com.neeraj.ResumeBuilderSpringBoot.service.SkillDetailDAO;


@RestController
@CrossOrigin(origins="*")
public class SkillDetailController 
{
	@Autowired
	ResumeDetailDAO resumeDetailDao;

	@Autowired
	SkillDetailDAO skillDetailDao; 
	
	@PostMapping("/skill/{id}")
	public ResponseEntity<SkillDetail> saveOtherDetail(@Valid @PathVariable("id") int resumeDetailid ,@Valid @RequestBody SkillDetail skillDatail) throws Exception
	{
		ResumeDetail resumeDetail=resumeDetailDao.findByResumeId(resumeDetailid);
		if(resumeDetail==null)
		{
			 throw new Exception();
		}
	
		SkillDetail newSkillDetail=new SkillDetail();
		
		newSkillDetail.setResumeDetail(resumeDetail);
		newSkillDetail.setExpxInMonth(skillDatail.getExpxInMonth());
		newSkillDetail.setExpxInYear(skillDatail.getExpxInMonth());
		newSkillDetail.setLevel(skillDatail.getLevel());
		newSkillDetail.setName(skillDatail.getName());
	
		SkillDetail copySkillDetail =skillDetailDao.saveSkillDetails(newSkillDetail);
		
		if(copySkillDetail==null)
		{
			 throw new Exception();
		}
		
		
		return new ResponseEntity<SkillDetail>(copySkillDetail,HttpStatus.OK);
	}

}
