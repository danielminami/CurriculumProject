package com.CurriculumProject.CurriculumProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CurriculumProject.CurriculumProject.Models.Model_Certification;

@Repository
public interface Repository_Certification extends JpaRepository <Model_Certification, Integer> {

}
