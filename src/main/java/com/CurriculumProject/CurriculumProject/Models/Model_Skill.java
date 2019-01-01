package com.CurriculumProject.CurriculumProject.Models;

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
@Table (name="tb_skill")
public class Model_Skill extends Model_Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(max = 60)
    private String name;
    
    @NotNull
	@Size(max = 30)
    private String level;
    
	@NotNull
	@Size(max = 4)
    private String experience_years;
	
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExperience_years() {
		return experience_years;
	}

	public void setExperience_years(String experience_years) {
		this.experience_years = experience_years;
	}

	public Model_PersonalData getPersonalDataId() {
		return personalDataId;
	}

	public void setPersonalDataId(Model_PersonalData personalDataId) {
		this.personalDataId = personalDataId;
	}
	
    
    
}
