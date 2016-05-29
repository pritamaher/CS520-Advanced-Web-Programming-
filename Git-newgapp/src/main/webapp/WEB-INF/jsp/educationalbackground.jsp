<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h1><center>Educational Background Information</center></h1>


<body>
<form:form modelAttribute="educationalbackground">
<table class="table table-condensed">
<tr><td>
 College Name</td><td><form:input path="collegename" class="form-control"/><form:errors path="collegename" /></td></tr>
 <tr><td>
 Major </td><td><form:input path="major" class="form-control"/><form:errors path="major" /></td></tr>
 <tr><td>
 Degree </td><td><form:input path="degree" class="form-control"/><form:errors path="degree" /></td></tr>
 <tr><td>
 Start Date</td><td><input type="date" name="sdate" class="form-control" Required/></td></tr>
 <tr><td>
 Complete Date</td><td><input type="date" name="edate" class="form-control" Required/></td></tr>
 <tr><td>
 Graduation Date</td><td><input type="date" name="ddate" class="form-control" Required/></td></tr>
 
 </table>
<input class="btn btn-primary" type="submit" value="Add Another Degree" onclick="form.action='addanothereducationalbackground.html';"/>
<input type="hidden" name="applid" value="${appid}">
<input type="hidden" name="pro" value="${pro}">
<input type="hidden" name="userid" value="${userid}">
 <input type="hidden" name="applicantid" value="${applicantid}">
 <input type="hidden" name="departmentid" value="${departmentid}">
 <input class="btn btn-primary" type="submit" value="Save and Finish Later" onclick="form.action='save.html';"/>
 <input class="btn btn-primary" type="submit" value="submit">
</form:form>
</body>
</html>