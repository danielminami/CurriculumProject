package com.CurriculumProject.CurriculumProject.Models;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="tb_project")
public class Model_Project extends Model_Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String role;
	
    @ElementCollection
    private List<String> description;
    
    @ElementCollection
    private List<String> technology;
    
    @ElementCollection
    private List<String> result;
	
    @NotNull
    private String start_year;
    
    private String end_year;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personal_data_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Model_PersonalData personalDataId;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public List<String> getTechnology() {
		return technology;
	}

	public void setTechnology(List<String> technology) {
		this.technology = technology;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public String getStart_year() {
		return start_year;
	}

	public void setStart_year(String start_year) {
		this.start_year = start_year;
	}

	public String getEnd_year() {
		return end_year;
	}

	public void setEnd_year(String end_year) {
		this.end_year = end_year;
	}

	public Model_PersonalData getPersonalDataId() {
		return personalDataId;
	}

	public void setPersonalDataId(Model_PersonalData personalDataId) {
		this.personalDataId = personalDataId;
	}
	
    
    
}
