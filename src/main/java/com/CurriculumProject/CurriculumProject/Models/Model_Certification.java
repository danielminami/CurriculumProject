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
@Table (name="tb_certification")
public class Model_Certification extends Model_Audit {
	
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
    private String institution;
    
    @NotNull
	@Size(max = 100)
    private String description;
    
    
    //types: Award, Certification or Volunteerism
    @NotNull
	@Size(max = 100)
    private String type;
    


	@NotNull
	@Size(max = 4)
    private String year;
	
    private String certificate_url;
	
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getCertificate_url() {
		return certificate_url;
	}

	public void setCertificate_url(String certificate_url) {
		this.certificate_url = certificate_url;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Model_PersonalData getPersonalDataId() {
		return personalDataId;
	}

	public void setPersonalDataId(Model_PersonalData personalDataId) {
		this.personalDataId = personalDataId;
	}
	
}
