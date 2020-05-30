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

import com.neeraj.ResumeBuilderSpringBoot.model.OtherDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.OtherDetailDAO;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;

@RestController
@CrossOrigin(origins="*")
public class OtherDetailController 
{
	@Autowired
	ResumeDetailDAO resumeDetailDao;
	
	@Autowired
	OtherDetailDAO otherDetailDao;
	
	//Save OtherDetails
	@PostMapping("/Other/{id}")
	public ResponseEntity<OtherDetail> saveOtherDetail(@Valid @PathVariable("id") int resumeDetailid ,@Valid @RequestBody OtherDetail otherDatail) throws Exception
	{
		ResumeDetail resumeDetail=resumeDetailDao.findByResumeId(resumeDetailid);
		if(resumeDetail==null)
		{
			 throw new Exception();
		}
		
		OtherDetail newOtherDetail=new OtherDetail();
		newOtherDetail.setResumeDetail(resumeDetail);
		newOtherDetail.setDiscription(otherDatail.getDiscription());
		newOtherDetail.setName(otherDatail.getName());
		newOtherDetail.setYear(otherDatail.getYear());
		
		OtherDetail copyOtherDetail=otherDetailDao.saveOtherDetail(newOtherDetail);
		
		if(copyOtherDetail==null)
		{
			throw new Exception();
		}
		
		return new ResponseEntity<OtherDetail>(copyOtherDetail,HttpStatus.OK);
	}	
	
}
