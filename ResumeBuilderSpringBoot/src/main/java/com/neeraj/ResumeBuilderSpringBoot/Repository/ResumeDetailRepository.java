package com.neeraj.ResumeBuilderSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;

public interface ResumeDetailRepository extends JpaRepository<ResumeDetail,Integer>
{

}
