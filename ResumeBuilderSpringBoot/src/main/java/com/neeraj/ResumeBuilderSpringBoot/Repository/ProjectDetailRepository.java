package com.neeraj.ResumeBuilderSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.ResumeBuilderSpringBoot.model.ProjectDetail;

public interface ProjectDetailRepository extends JpaRepository<ProjectDetail,Integer>{

	@Query(value = "select * from project_details e where e.resume_detail_id = ?1", nativeQuery = true)
	List<ProjectDetail> findByResumeDetailId(int id);

}
