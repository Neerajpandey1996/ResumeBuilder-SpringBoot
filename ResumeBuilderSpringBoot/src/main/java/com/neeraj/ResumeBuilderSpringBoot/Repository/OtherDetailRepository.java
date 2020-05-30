package com.neeraj.ResumeBuilderSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.ResumeBuilderSpringBoot.model.OtherDetail;

public interface OtherDetailRepository extends JpaRepository<OtherDetail,Integer>{

	@Query(value = "select * from other_detail e where e.resume_detail_id = ?1", nativeQuery = true)
	List<OtherDetail> findByResumeDetailId(int id);

}
