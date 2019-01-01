package com.CurriculumProject.CurriculumProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CurriculumProject.CurriculumProject.Models.Model_Project;

@Repository
public interface Repository_Project extends JpaRepository<Model_Project, Integer> {

}
