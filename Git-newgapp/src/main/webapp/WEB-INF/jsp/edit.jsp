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
<nav class="navbar navbar navbar-inverse">
  <div class="container">
<p class="navbar-text navbar-left"><a href="admin.html" style="color: #ffffff">View Details of the Department</a><br />
<p class="navbar-text navbar-left"><a href="addnewdepartment.html" style="color: #ffffff">Add New Department</a><br />
<p class="navbar-text navbar-left"><a href="editdepartments.html" style="color: #ffffff"> Edit Departments</a><br />
<p class="navbar-text navbar-left"><a href="login.html" style="color: #ffffff">Logout</a>

  </div>
</nav>

<form:form modelAttribute="department">
<div class="panel panel-default">
  <div class="panel-heading">Change Department Name</div>


<table class="table table-responsive">

<tr><td>Enter New Department Name </td><td><form:input path="departmentname"/></td>
<td><input class="btn btn-primary btn-lnk" type="Submit" name="editdepartments" value="Save"></td></tr>
</table>

  
</div>
</form:form>

<div class="panel panel-default">
  <div class="panel-heading">Add/Remove Programs</div>


<table class="table table-responsive">
<tr><th>Program Name</th><th>Action</th></tr>
<c:forEach items="${programs}" var="p">
<c:if test="${department.id eq p.department.id}">
<tr>
<td>${p.programname}</td>
<td><a class="btn btn-primary btn-lnk"href="remove.html?id=${p.id}&depid=${department.id}">Remove</a>
</td>
</tr>

</c:if>
 
</c:forEach>
</table>

  
</div>
<a class="btn btn-primary btn-lnk" href="addnewprograms.html?id=${department.id}">Add New Program</a><br /><br/>

<div class="panel panel-default">
  <div class="panel-heading">Add/Remove Additional Fields</div>


<table class="table table-responsive">
<tr><th>Additional Requirment</th><th>Action</th></tr>
<c:forEach items="${additionalfields}" var="af">
<c:if test="${department.id eq af.department.id}">
<tr><td>${af.additionalfieldname}</td>
<td><a class="btn btn-primary btn-lnk" href="remove1.html?id=${af.additionalfield}&depid=${department.id}">Remove</a></td></tr>
</c:if>
</c:forEach>
</table>


  
</div>



<a class="btn btn-primary btn-lnk" href="addnewadditionalfield.html">Add New AdditionalField</a>

</body>
</html>