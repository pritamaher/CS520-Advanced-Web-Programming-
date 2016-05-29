package springmvc.model.dao;

import java.util.List;

import springmvc.model.Department;
import springmvc.model.User;


public interface DepartmentDao {

	   Department getDepartment( Integer id );
	    List<Department> getDepartments();
	    Department savedepartment (Department department);
}

