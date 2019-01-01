package com.CurriculumProject.CurriculumProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CurriculumProject.CurriculumProject.Models.Model_Skill;

@Repository
public interface Repository_Skill extends JpaRepository<Model_Skill, Integer> {

}
