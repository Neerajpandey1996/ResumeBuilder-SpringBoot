package com.neeraj.ResumeBuilderSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neeraj.ResumeBuilderSpringBoot.model.SkillDetail;

public interface SkillDetailRepository extends JpaRepository<SkillDetail,Integer>{

	@Query(value = "select * from skill_details e where e.resume_detail_id = ?1", nativeQuery = true)
	List<SkillDetail> findByResumeDetailId(int id);

}
