package springmvc.model.dao;

import java.util.List;

import springmvc.model.Applicant;

public interface ApplicantDao {
	
	List<Applicant> getApplicants();	
	
	Applicant saveApplicant(Applicant applicant);
	
	Applicant getApplicant(Integer id);

}
