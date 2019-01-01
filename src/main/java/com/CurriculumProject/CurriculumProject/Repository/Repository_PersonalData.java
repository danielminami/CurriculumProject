package com.CurriculumProject.CurriculumProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CurriculumProject.CurriculumProject.Models.Model_PersonalData;

@Repository
public interface Repository_PersonalData extends JpaRepository<Model_PersonalData, Integer> {

	List<Model_PersonalData> findByName(String name);
		
}
