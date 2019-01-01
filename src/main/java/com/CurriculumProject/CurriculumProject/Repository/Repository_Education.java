package com.CurriculumProject.CurriculumProject.Repository;

import com.CurriculumProject.CurriculumProject.Models.Model_Education;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface Repository_Education extends JpaRepository <Model_Education, Integer> {
	
	//List<Model_Education> findByPersonalDataId(Integer PersonalDataId);
	
	@Query(value="SELECT * FROM tb_education WHERE personal_data_id = ?1", nativeQuery = true)
	List<Model_Education> findByPersonalDataIdQuery(Integer PersonalDataId);
	 		
}