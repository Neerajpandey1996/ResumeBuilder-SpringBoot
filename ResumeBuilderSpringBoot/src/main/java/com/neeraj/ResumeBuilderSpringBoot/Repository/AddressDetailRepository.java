package com.neeraj.ResumeBuilderSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.ResumeBuilderSpringBoot.model.AddressDetail;

public interface AddressDetailRepository extends JpaRepository<AddressDetail,Integer>
{
}
