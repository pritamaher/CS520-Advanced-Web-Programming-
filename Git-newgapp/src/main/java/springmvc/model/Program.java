package springmvc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "programname")
    private String programname;
    
    
    	@OneToOne
    private Department department;
    
    @Column(name = "programstatus")
    private String programstatus;
    
    @Column(name = "programstartdate")
    private String programstartdate;
    
    @Column(name = "programenddate")
    private String programenddate;

 
	
    public Program()
    {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getProgramstatus() {
		return programstatus;
	}

	public void setProgramstatus(String programstatus) {
		this.programstatus = programstatus;
	}

	public String getProgramstartdate() {
		return programstartdate;
	}

	public void setProgramstartdate(String programstartdate) {
		this.programstartdate = programstartdate;
	}

	public String getProgramenddate() {
		return programenddate;
	}

	public void setProgramenddate(String programenddate) {
		this.programenddate = programenddate;
	}

	
	

	   
}