package springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToOne
    private User user;
    
   
    
    public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	@ManyToOne
    private Applicant applicant;
    
    @OneToOne
    private Program program;
    
    @ManyToOne
    private Department department;
    
    
    private String term;
    
    private Date startdate;
    
    private Date lastmodifieddate;
    
    private String status;
    
    public String getTerm() {
		return term;
	}



	public void setTerm(String term) {
		this.term = term;
	}


	private Date completedate;
    
    private String comment;
    
    
    public Application()
    {
    }



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	

	public Applicant getApplicant() {
		return applicant;
	}



	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}



	public Program getProgram() {
		return program;
	}



	public void setProgram(Program program) {
		this.program = program;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}


	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}


	public Date getCompletedate() {
		return completedate;
	}


	public void setCompletedate(Date completedate) {
		this.completedate = completedate;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

 
}