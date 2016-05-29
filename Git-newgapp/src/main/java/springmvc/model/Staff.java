package springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staffs")
public class Staff {

    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToOne
    private User user;
    
    @Column(name = "stafftype")
    private String stafftype;
    
    @Column(name = "lastname", nullable = true, unique = true)
    private String lastname;
    
    @Column(name = "firstname", nullable = true, unique = true)
    private String firstname;
    
        
    
    public Staff()
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







	public String getStafftype() {
		return stafftype;
	}



	public void setStafftype(String stafftype) {
		this.stafftype = stafftype;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

 
}