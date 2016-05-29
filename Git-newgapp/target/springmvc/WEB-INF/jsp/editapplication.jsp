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
<h1><center>Edit Application</center></h1>



<form action="editapplication.html" method="POST" enctype="multipart/form-data">

<table class="table">
 
<tr class="active"><td>
First Name </td> <td><input  class="form-control" name="fname" type="text" value="${user.firstname}" Required/> </td></tr>
<tr class="success"><td>Last Name</td><td><input  class="form-control" name="lname" type="text" value="${user.lastname}" Required/></td></tr>
 


<tr class="warning"><td>Term</td><td>
<select class="form-control" name="term"  onchange="${application.term}" Required>
<option value="${application.term}">${application.term }</option>

<c:if test="${application.term != 'Spring 2016'}">
<option value="Spring 2016">Spring 2016</option>
</c:if>
<c:if test="${application.term !=  'Summer 2016'}">
<option value="Summer 2016">Summer 2016</option>
</c:if>
<c:if test="${application.term != 'Fall 2016'}">
<option value="Fall 2016">Fall 2016</option>
</c:if>
<c:if test="${application.term !=  'Winter 2017'}">
<option value="Winter 2017">Winter 2017</option>
</c:if>
<c:if test="${application.term !=  'Spring 2017'}">
<option value="Spring 2017">Spring 2017</option>
</c:if>
</select>
</td></tr>

<tr class="danger"><td>Department</td><td>
<select class="form-control" name="departmentid" required>
<option value="${department.id}">${department.departmentname}</option>
</select></td></tr>
<tr class="active"><td>Program</td><td>
<select class="form-control" name="programid" onchange="${program}" required>
<option value="${program.id}">${program.programname}</option>
<c:forEach items="${programs}" var="p">
<c:if test="${p.department.id eq department.id}">
<c:if test="${program ne p.programname}">
<option value="${p.id}">${p.programname}</option>
</c:if>
</c:if>
</c:forEach>
</select>
</td></tr>

<tr class="success"><td>
Citizenship </td><td><input class="form-control" type="text" name="citizenship" value="${applicantss.citizenship}" Required/></td></tr>
<tr class="active"><td>
Gender</td><td>
<input  <c:if test=" ${applicantss.gender eq 'Male' }">checked</c:if>   name="gender" type="radio" value="Male"/>Male
<input <c:if test="${applicantss.gender eq 'Female' }">checked</c:if> name="gender" type="radio" value="Female"/>Female
<input <c:if test="${applicantss.gender eq 'Other' }">checked</c:if>  name="gender" type="radio" value="Other"/>Other</td></tr>

<tr class="warning"><td>
Phone Number</td><td><input class="form-control" name="phonenumber" type="text" value="${applicantss.phonenumber}" Required/></td></tr>
<tr class="danger"><td>
Date of Birth</td><td><input class="form-control" name="datebirth" type="date"  value="${applicantss.dateofbirth}" value="${applicantss.dateofbirth}" Required/></td></tr>
<tr class="active"><td>
Type</td><td><input class="form-control" name="type" type="text" value="${applicantss.type}" Required/></td></tr>
<tr class="success"><td>
Toefl</td><td><input class="form-control" name="toefl" type="text" value="${applicantss.toefl}" Required/></td></tr>
<tr class="warning"><td>
GRE</td><td><input class="form-control" name="gre" type="text" value="${applicantss.gre}" Required/></td></tr>
<tr class="danger"><td>
Gpa</td><td><input class="form-control" name="gpa" type="text" value="${applicantss.gpa}" Required/></td></tr>
<tr class="active"><td>
File </td><td><a href="download.html?name=${applicantss.transcript}">${applicantss.transcript}</a></<td><input class="form-control" type="file" name="file" Required/></td> 
</tr>
</table>

  
  <table class="table">
<h2>Educational Backgrounds</h2>
<tr class="active"><th>Degree Name</th><th>Major</th><th>Action</th></tr>
<c:forEach items="${ebs}" var="e">
<c:if test="${applicantss.id eq e.applicant.id && application.id eq e.application.id}">
<tr>
<td>${e.degree}</td>
<td>${e.major}</td>
<td><a href="removeeb.html?ebid=${e.id}&applicationid=${application.id}&applicantid=${applicantss.id}">Remove</a>

</c:if>
</c:forEach>

</table>

<td><a class="btn btn-primary" href="adddegree.html?applicationid=${application.id}&applicantid=${applicantss.id}">Add New Degree</a>
<input type="hidden" name="applicationid" value="${application.id}"/>
<input type="hidden" name="id" value="${applicantss.id}"/>

<input type="hidden" name="userid" value="${applicantss.user.id}"/><br />
<center><input class="btn btn-primary" type="Submit" name="" value="Save">
<input class="btn btn-primary" type="submit" value="Submit" onclick="form.action='submit.html';"/>
<a  class="btn btn-primary btn-lnk" href="login.html">Logout</a>
<a  class="btn btn-primary btn-lnk" href="student.html?user=${user.id}">Go Back</a>
</center>
</form>


</body>
</html>


