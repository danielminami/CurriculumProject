package com.CurriculumProject.CurriculumProject.Controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.CurriculumProject.CurriculumProject.Models.Model_Certification;
import com.CurriculumProject.CurriculumProject.Repository.Repository_Certification;
import com.CurriculumProject.CurriculumProject.Repository.Repository_PersonalData;
import com.CurriculumProject.CurriculumProject.Resources.ResourceNotFoundException;

@RestController
@RequestMapping(path="/certification") 
public class Controller_Certification {
	
	@Autowired
	Repository_Certification repository;
	
	@Autowired
	Repository_PersonalData repositoryPersonalData;
	
    @GetMapping("/list")
    public List<Model_Certification> getAllEducation() {
    	return repository.findAll();
    }
    
    @PostMapping(path="/create/{personalDataId}")
    public Model_Certification create(@PathVariable (value = "personalDataId") Integer personalDataId,
               @Valid @RequestBody Model_Certification certification) {
  	
        return repositoryPersonalData.findById(personalDataId).map(pdata -> {
        	certification.setPersonalDataId(pdata);
            return repository.save(certification);
        })
        .orElseThrow(() -> 
        new ResourceNotFoundException("Personal Id: " + personalDataId + " not found"));
    }
    
	@DeleteMapping(path="/delete")
	public @ResponseBody Model_Certification delete (@RequestBody Model_Certification n) {
		repository.delete(n);
		return n;
	}

}
