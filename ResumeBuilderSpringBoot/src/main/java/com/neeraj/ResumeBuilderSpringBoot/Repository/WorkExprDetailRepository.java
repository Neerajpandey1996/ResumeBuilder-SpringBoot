package com.neeraj.ResumeBuilderSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.ResumeBuilderSpringBoot.model.WorkExprDetail;

public interface WorkExprDetailRepository extends JpaRepository<WorkExprDetail,Integer>
{

	@Query(value = "select * from work_expr_details e where e.resume_detail_id = ?1", nativeQuery = true)
	List<WorkExprDetail> findByResumeDetailId(int id);

}
