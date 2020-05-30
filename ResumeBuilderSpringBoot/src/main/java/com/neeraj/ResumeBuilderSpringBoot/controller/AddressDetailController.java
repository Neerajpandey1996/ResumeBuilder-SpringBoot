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

import com.neeraj.ResumeBuilderSpringBoot.model.AddressDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.AddressDetailDAO;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;

//@RestController
@CrossOrigin(origins="*")
public class AddressDetailController 
{

	@Autowired
	ResumeDetailDAO resumeDetailDao;
	
	@Autowired
	AddressDetailDAO addressDetailDao;
	
	//Save details
	@PostMapping("/Address/{id}")
	public ResponseEntity<AddressDetail> saveAddressDetail(@Valid @PathVariable("id") int resumeDetailid ,@Valid @RequestBody AddressDetail addressDatail) throws Exception
	{
		ResumeDetail resumeDetail=resumeDetailDao.findByResumeId(resumeDetailid);
		if(resumeDetail==null)
		{
			 throw new Exception();
		}
		
		AddressDetail newaddressDetail=new AddressDetail();
		
		newaddressDetail.setResumeDetail(resumeDetail);
		newaddressDetail.setCity(addressDatail.getCity());
		newaddressDetail.setFullName(addressDatail.getFullName());
		newaddressDetail.setState(addressDatail.getState());
		newaddressDetail.setStreetAddress(addressDatail.getStreetAddress());
		newaddressDetail.setZipCode(addressDatail.getZipCode());
		
		AddressDetail copyaddressDetail=addressDetailDao.saveAddressDetail(newaddressDetail);
		
		if(copyaddressDetail==null)
		{
			throw new Exception();
		}
		
		return new ResponseEntity<AddressDetail>(copyaddressDetail,HttpStatus.OK);
	}

}
