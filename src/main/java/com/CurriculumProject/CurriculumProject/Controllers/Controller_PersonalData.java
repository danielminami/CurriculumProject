package com.CurriculumProject.CurriculumProject.Controllers;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.CurriculumProject.CurriculumProject.Models.Model_PersonalData;
import com.CurriculumProject.CurriculumProject.Repository.Repository_Education;
import com.CurriculumProject.CurriculumProject.Repository.Repository_PersonalData;

@RestController    
@RequestMapping(path="/personaldata") 
public class Controller_PersonalData {
	
	@Autowired 
	private Repository_PersonalData userRepository;
	
	@Autowired
	Repository_Education repositoryEducation;	

	
	@PostMapping(path="/create")
	public @ResponseBody Model_PersonalData create (@RequestBody Model_PersonalData n) {
		return userRepository.save(n);
	}

	@GetMapping(path="/list")
	public @ResponseBody Iterable<Model_PersonalData> list() {
		return userRepository.findAll();
	}
	
	@PostMapping(path="/getById")
	public @ResponseBody Optional<Model_PersonalData> getById(@RequestBody Model_PersonalData n) {
		return userRepository.findById(n.getId());
	}
	
	@PostMapping(path="/getByName")
	public @ResponseBody Iterable<Model_PersonalData> getByName(@RequestBody Model_PersonalData n) {
		return userRepository.findByName(n.getName());
	}
	
	@PutMapping(path="/update")
	public @ResponseBody Model_PersonalData update (
			@RequestBody Model_PersonalData n) {
				return userRepository.save(n);
	}
	
	@DeleteMapping(path="/delete")
	public @ResponseBody Model_PersonalData delete (@RequestBody Model_PersonalData n) {
		userRepository.delete(n);
		return n;
	}

/*	@PostMapping(path="/create")
	public @ResponseBody Model_PersonalData addNewUser (@RequestParam String name
			, @RequestParam String email, @RequestParam String address) {
		Model_PersonalData n = new Model_PersonalData();
		n.setName(name);
		n.setEmail(email);
		n.setAddress(address);
		userRepository.save(n);
		return n;
	}
*/
	
}


