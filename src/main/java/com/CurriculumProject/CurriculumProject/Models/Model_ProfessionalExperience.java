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
@Table (name="tb_professional_experience")
public class Model_ProfessionalExperience extends Model_Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(max = 100)
    private String company;
    
    @NotNull
	@Size(max = 100)
    private String city;
    
	@NotNull
	@Size(max = 100)
    private String country;

    @NotNull
    @Size(max = 100)
    private String position;
	
    @ElementCollection
    private List<String> responsabilities;
    
    @ElementCollection
    private List<String> achiviements;
	
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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
	
    public List<String> getResponsabilities() {
		return responsabilities;
	}

	public void setResponsabilities(List<String> responsabilities) {
		this.responsabilities = responsabilities;
	}

	public List<String> getAchiviements() {
		return achiviements;
	}

	public void setAchiviements(List<String> achiviements) {
		this.achiviements = achiviements;
	}

	public Model_PersonalData getPersonalDataId() {
		return personalDataId;
	}

	public void setPersonalDataId(Model_PersonalData personalDataId) {
		this.personalDataId = personalDataId;
	}
    
}
