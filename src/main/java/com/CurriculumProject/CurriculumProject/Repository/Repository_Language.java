package com.CurriculumProject.CurriculumProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CurriculumProject.CurriculumProject.Models.Model_Language;

@Repository
public interface Repository_Language  extends JpaRepository <Model_Language, Integer> {

}
