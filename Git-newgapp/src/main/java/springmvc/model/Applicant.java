package springmvc.model;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @GeneratedValue
    private Integer id;
    
    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@OneToOne
    private User user;

    private Integer cin;
    
    private long phonenumber;
    
    private String gender;
    
    private Date dateofbirth;
    
    private String citizenship;
    
    private String type;
    
    private Integer toefl;
    
    private Integer gre;
    
    private float gpa;
    
    private String transcript;
    
    @OneToMany
    List<EducationalBackground> eb;
    
  


	public String getTranscript() {
		return transcript;
	}


	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}


	public List<EducationalBackground> getEb() {
		return eb;
	}


	public void setEb(List<EducationalBackground> eb) {
		this.eb = eb;
	}


	public Applicant()
    {
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCin() {
		return cin;
	}


	public void setCin(Integer cin) {
		this.cin = cin;
	}


	


	public long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getCitizenship() {
		return citizenship;
	}


	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getToefl() {
		return toefl;
	}


	public void setToefl(Integer toefl) {
		this.toefl = toefl;
	}


	public Integer getGre() {
		return gre;
	}


	public void setGre(Integer gre) {
		this.gre = gre;
	}


	public float getGpa() {
		return gpa;
	}


	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

 
} 