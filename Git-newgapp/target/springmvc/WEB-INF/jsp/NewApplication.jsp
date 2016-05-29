
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>GAPP</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body class='container' link="#CC0000">
<h1><center>GAPP</center></h1>

<body>
<script type="text/javascript" src="javascript/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#department').change(function(event) {
	        var department = $("select#department").val();
	        $.get('ajax.html', {
	                departmentName : department
	        
	        }, function(response) {

	        var select = $('#prog');
	        select.find('option').remove();
	          $.each(response, function(index, value) {
	          $('<option>').val(value).text(value).appendTo(select);
	      });
	        });
	        });
	});
</script>
</head>
<form action="NewApplication.html" method="POST" enctype="multipart/form-data">
<div class="container">
    <h1 class="well">Registration Form</h1>

	<div class="col-lg-12 well">
	<div class="row">
				
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-9 form-group">
								<label>Term</label>
										<select name="term" class="form-control" required>
										<option value="Spring 2016">Spring 2016</option>
										<option value="Summer 2016">Summer 2016</option>
										<option value="Fall 2016">Fall 2016</option>
										<option value="Winter 2017">Winter 2017</option>
										<option value="Spring 2017">Spring 2017</option>
										</select>
								
								</div>

                            <div class="col-sm-6 form-group">
    							<label>Department</label>
										    <select id="department" name="departmentid" class="form-control" required>
								                <option>Select Department</option>
												<c:forEach items="${departments}" var="d">
												<option value="${d.id}">${d.departmentname}</option>
												</c:forEach>
												</select>
										</div>
                             
                            <div class="col-sm-6 form-group">
    							<label>Program</label>
						  			<select id="prog" name="prog" class="form-control" required>
				                	<option>Select Program</option>
				        			</select>
				        			</div>
                            </div>
                            </div>
                           
                            </div>
                            </div>
                            
<div class="col-lg-12 well">
	<div class="row">
				
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Name</label>
									<input type="text" value="${user.firstname}" class="form-control" readonly/>
								
								</div>
								
								<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<input type="text"value="${user.lastname}" class="form-control" readonly/>
								</div>
								
							<div class="col-sm-12 form-group">
							<label>Citizenship</label>
    						   <input type="text" name="citizenship" class="form-control" Required/>
							</div>
							
   								<div class="col-sm-9 form-group">
								    <label>Gender</label>
								      <div class="radio">
								        <label>
								          <input type="radio" name="gender" value="Male" checked>
								          Male
								        </label>
								      </div>
								      <div class="radio">
								        <label>
								          <input type="radio" name="gender" value="Female">
								          Female
								        </label>
								      </div>
								      <div class="radio">
								        <label>
								          <input type="radio" name="gender" value="Other">
								          Other
								        </label>
								      </div>
								    </div>
								<div class="col-sm-6 form-group">
									<label>Phone Number</label>
										<input type="text" name="phonenumber" class="form-control" Required/>
									</div>

									<div class="col-sm-6 form-group">
										<label>Date of birth</label>
										      	<input type="date" name="datebirth" class="form-control" Required/>
										 </div>
										
									<div class="col-sm-12 form-group">
										<label>Type</label>
												<select name="type" class="form-control" Required>
												<option value="Domestic">Domestic</option>
												<option value="International">International</option>
												</select>
									      	</div>
  										<div class="col-sm-6 form-group">
  												<label>TOEFL</label>
											<input type="text" name="toefl" class="form-control" Required/>
    									</div>
    									<div class="col-sm-6 form-group">
    										<label>GRE</label>
    									     <input type="text" name="gre" class="form-control" Required/>
    										</div>
    										
    										<div class="col-sm-6 form-group">
    											<label>GPA</label>
    												 <input type="text" name="gpa" class="form-control" Required/>
    											</div>
    											
    											<div class="col-sm-9 form-group">
    												<label>File</label>
    													<input type="file" name="file" class="form-control"  Required/>
    												</div>
    												
    												
    												
    												

								   								
                            
                            </div>
                            </div>
                            <input type="hidden" name="userid" value="${user.id}">
		<center><input type="submit" value="Save And Continue" class="btn btn-lg btn-info btn-primary"></center>

                            </div>
                            </div>
                            
                            
                            
                            
                            

</form>

</body>
</html>
