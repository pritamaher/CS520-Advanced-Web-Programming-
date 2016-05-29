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
@Table(name = "educationalbackgrounds")
public class EducationalBackground {

    @Id
    @GeneratedValue
    private Integer id;
    
    public Application getApplication() {
		return application;
	}




	public void setApplication(Application application) {
		this.application = application;
	}


	@ManyToOne
    private Application application;
    
    @OneToOne
    private Applicant applicant;
    
    @Column(name = "collegename")
    private String collegename;
    
    @Column(name = "degree")
    private String degree;
    
    @Column(name = "startdate")
    private Date startdate;
    
    @Column(name = "enddate")
    private Date enddate;
    
    @Column(name = "degreeearneddate")
    private Date degreeearneddate;
    
    @Column(name = "major")
    private String major;
        
    
    public EducationalBackground()
    {
    }


	

	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Applicant getApplicant() {
		return applicant;
	}




	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}




	public String getCollegename() {
		return collegename;
	}


	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public Date getDegreeearneddate() {
		return degreeearneddate;
	}


	public void setDegreeearneddate(Date degreeearneddate) {
		this.degreeearneddate = degreeearneddate;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}

 
}