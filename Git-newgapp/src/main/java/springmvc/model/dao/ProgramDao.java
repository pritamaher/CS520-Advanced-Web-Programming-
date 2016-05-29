package springmvc.model.dao;

import java.util.List;

import springmvc.model.Program;
import springmvc.model.User;

public interface ProgramDao {
	
		
	
	   Program getprog( Integer id );

	    List<Program> getprograms();
	    
	    Program saveProgram(Program program);
	    
	    void removeProgram(Program program);
}
