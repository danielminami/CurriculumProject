package com.CurriculumProject.CurriculumProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CurriculumProject.CurriculumProject.Models.Model_ProfessionalExperience;

@Repository
public interface Repository_ProfessionalExperience extends JpaRepository <Model_ProfessionalExperience, Integer> {

}



