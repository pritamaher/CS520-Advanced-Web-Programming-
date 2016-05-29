package springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "additionalfieldvalues")
public class AdditionalFieldValue {

    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne
    private Application application;
    
    public AdditionalField getAdditionalfield() {
		return additionalfield;
	}




	public Application getApplication() {
		return application;
	}




	public void setApplication(Application application) {
		this.application = application;
	}




	public void setAdditionalfield(AdditionalField additionalfield) {
		this.additionalfield = additionalfield;
	}




	private String value;
    
    @ManyToOne
    private Applicant applicant;
    
    @ManyToOne
    private AdditionalField additionalfield; 
    
    
    
    public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	



	public String getValue() {
		return value;
	}




	public void setValue(String value) {
		this.value = value;
	}




	public Applicant getApplicant() {
		return applicant;
	}




	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}




	public AdditionalFieldValue()
    {
    }


	

}