package com.neeraj.ResumeBuilderSpringBoot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neeraj.ResumeBuilderSpringBoot.model.EducationDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;

@Repository
public interface EducationDetailRepository extends JpaRepository<EducationDetail,Integer>{

	@Query(value = "select * from education_details e where e.resume_detail_id = ?1", nativeQuery = true)
	List<EducationDetail> findByResumeDetailId(Integer id);

}
