package com.CurriculumProject.CurriculumProject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tb_education")
public class Model_Education extends Model_Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderColumn
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personal_data_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Model_PersonalData personalDataId;
	
    @NotNull
    private String institution;
    
    @NotNull
    private String degree_level;
   
    @NotNull
    private String course;
    
    @NotNull
    private String country;
    
    @NotNull
    private String start_year;
    
	@NotNull
    private String end_year;
	
	@NotNull
    private String lenght;
    


	public String getDegree_level() {
		return degree_level;
	}

	public void setDegree_level(String degree_level) {
		this.degree_level = degree_level;
	}

    public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
    public String getLenght() {
		return lenght;
	}

	public void setLenght(String lenght) {
		this.lenght = lenght;
	}

	public Model_PersonalData getPersonalDataId() {
		return personalDataId;
	}

	public void setPersonalDataId(Model_PersonalData personalDataId) {
		this.personalDataId = personalDataId;
	}
    
}