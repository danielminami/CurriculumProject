package com.CurriculumProject.CurriculumProject.Controllers;

import com.CurriculumProject.CurriculumProject.Resources.ResourceNotFoundException;
import com.CurriculumProject.CurriculumProject.Models.Model_Education;
import com.CurriculumProject.CurriculumProject.Repository.Repository_Education;
import com.CurriculumProject.CurriculumProject.Repository.Repository_PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;


@RestController
@RequestMapping(path="/education") 
public class Controller_Education {
	
	@Autowired
	Repository_Education repository;
	
	@Autowired
	Repository_PersonalData repositoryPersonalData;
	
	
    @GetMapping("/list")
    public List<Model_Education> getAllEducation() {
    	return repository.findAll();
    }
    
    @GetMapping("/getByPersonalDataId/{personalDataId}")
    public List<Model_Education>  
    	getAllEducationByUserId(@PathVariable (value = "personalDataId") Integer personalDataId) {
          	return repository.findByPersonalDataIdQuery(personalDataId);
    }
		
    @PostMapping(path="/create/{personalDataId}")
    public Model_Education create(@PathVariable (value = "personalDataId") Integer personalDataId,
               @Valid @RequestBody Model_Education education) {
  	
        return repositoryPersonalData.findById(personalDataId).map(pdata -> {
        	education.setPersonalDataId(pdata);
            return repository.save(education);
        }
        ).orElseThrow(
        	() -> new ResourceNotFoundException("Personal Id: " + personalDataId + " not found"));
    }

	@PutMapping(path="/update")
	public @ResponseBody Model_Education update (
			@RequestBody Model_Education n) {
				return repository.save(n);
	}
    

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return repository.findById(id).map(d -> {
			repository.delete(d);
	        return ResponseEntity.ok().build();
	    }).orElseThrow(
	    	() -> new ResourceNotFoundException("EducationId " + id + " not found"));
	}
}