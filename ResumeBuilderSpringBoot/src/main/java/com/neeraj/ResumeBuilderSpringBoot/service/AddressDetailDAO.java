package com.neeraj.ResumeBuilderSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.ResumeBuilderSpringBoot.Repository.AddressDetailRepository;
import com.neeraj.ResumeBuilderSpringBoot.model.AddressDetail;

@Service
public class AddressDetailDAO 
{

	@Autowired
	AddressDetailRepository addressDetailRepo;
	
	
	//Save Address Detail
	public AddressDetail saveAddressDetail(AddressDetail addressDetail)
	{
		return addressDetailRepo.save(addressDetail);
	}
}
