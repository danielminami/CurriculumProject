package com.CurriculumProject.CurriculumProject.Models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="tb_personal_data")
public class Model_PersonalData extends Model_Audit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max = 100)
    private String email;
    
	@Size(max = 100)
    private String address;
	
	@Size(max = 100)
    private String phone;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "personalDataId")
    private Set<Model_Education> education = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "personalDataId")
    private Set<Model_ProfessionalExperience> professionalExperience = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "personalDataId")
    private Set<Model_Language> language = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "personalDataId")
    private Set<Model_Certification> certification = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "personalDataId")
    private Set<Model_Skill> skill = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "personalDataId")
    private Set<Model_Project> project = new HashSet<>();
    
    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
    
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Model_Education> getEducation() {
		return education;
	}

	public void setEducation(Set<Model_Education> education) {
		this.education = education;
	}

	public Set<Model_ProfessionalExperience> getProfessionalExperience() {
		return professionalExperience;
	}

	public void setProfessionalExperience(Set<Model_ProfessionalExperience> professionalExperience) {
		this.professionalExperience = professionalExperience;
	}

	public Set<Model_Language> getLanguage() {
		return language;
	}

	public void setLanguage(Set<Model_Language> language) {
		this.language = language;
	}

	public Set<Model_Certification> getCertification() {
		return certification;
	}

	public void setCertification(Set<Model_Certification> certification) {
		this.certification = certification;
	}

	public Set<Model_Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Model_Skill> skill) {
		this.skill = skill;
	}

	public Set<Model_Project> getProject() {
		return project;
	}

	public void setProject(Set<Model_Project> project) {
		this.project = project;
	}
	
}


