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


<body>
<form action="addprogramss.html" method="post">
Department in which you want to add program:-
<select name="id">
<c:forEach items="${departments}" var="d">
<option value="${d.id}">${d.departmentname}</option>
</c:forEach>
</select>
<br />Enter the Program Name <input type="text" name="programname"/><br/>

<input type="submit" value="save">
</form>



</body>
</html> 