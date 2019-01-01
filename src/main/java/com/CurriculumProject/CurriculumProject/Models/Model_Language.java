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
@Table (name="tb_language")
public class Model_Language extends Model_Audit{

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
    private String cefr;
    
	@NotNull
	@Size(max = 100)
    private String test_taken;
	
	@NotNull
	@Size(max = 4)
    private String year;

	
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


	public String getCefr() {
		return cefr;
	}


	public void setCefr(String cefr) {
		this.cefr = cefr;
	}


	public String getTest_taken() {
		return test_taken;
	}


	public void setTest_taken(String test_taken) {
		this.test_taken = test_taken;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public Model_PersonalData getPersonalDataId() {
		return personalDataId;
	}


	public void setPersonalDataId(Model_PersonalData personalDataId) {
		this.personalDataId = personalDataId;
	}
	
    
    
}
