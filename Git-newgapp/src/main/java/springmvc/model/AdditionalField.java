package springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "additionalfields")
public class AdditionalField {

    @Id
    @GeneratedValue
    private Integer additionalfield;
    
    
    @ManyToOne
    private Department department;
    
    private String additionalfieldname;
    
    private String additionalfieldtype;
    
    private String choice;
    
        
    
    public AdditionalField()
    {
    }



	public Integer getAdditionalfield() {
		return additionalfield;
	}



	public void setAdditionalfield(Integer additionalfield) {
		this.additionalfield = additionalfield;
	}



	



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	



	public String getAdditionalfieldname() {
		return additionalfieldname;
	}



	public void setAdditionalfieldname(String additionalfieldname) {
		this.additionalfieldname = additionalfieldname;
	}



	public String getAdditionalfieldtype() {
		return additionalfieldtype;
	}



	public void setAdditionalfieldtype(String additionalfieldtype) {
		this.additionalfieldtype = additionalfieldtype;
	}



	public String getChoice() {
		return choice;
	}



	public void setChoice(String choice) {
		this.choice = choice;
	}


 
}