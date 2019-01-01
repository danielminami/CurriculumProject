package com.CurriculumProject.CurriculumProject.Controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.CurriculumProject.CurriculumProject.Models.Model_Skill;
import com.CurriculumProject.CurriculumProject.Repository.Repository_PersonalData;
import com.CurriculumProject.CurriculumProject.Repository.Repository_Skill;
import com.CurriculumProject.CurriculumProject.Resources.ResourceNotFoundException;

@RestController
@RequestMapping(path="/skill") 
public class Controller_Skill {

	@Autowired
	Repository_Skill repository;
	
	@Autowired
	Repository_PersonalData repositoryPersonalData;
	
    @GetMapping("/list")
    public List<Model_Skill> getAllEducation() {
    	return repository.findAll();
    }
    
    @PostMapping(path="/create/{personalDataId}")
    public Model_Skill create(@PathVariable (value = "personalDataId") Integer personalDataId,
               @Valid @RequestBody Model_Skill body) {
  	
        return repositoryPersonalData.findById(personalDataId).map(pdata -> {
        	body.setPersonalDataId(pdata);
            return repository.save(body);
        })
        .orElseThrow(() -> 
        new ResourceNotFoundException("Personal Id: " + personalDataId + " not found"));
    }
    
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return repository.findById(id).map(d -> {
			repository.delete(d);
	        return ResponseEntity.ok().build();})
		.orElseThrow(() -> 
		new ResourceNotFoundException("skillsId " + id + " not found"));
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody Model_Skill delete (@RequestBody Model_Skill n) {
		repository.delete(n);
		return n;
	}
	
}
