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
<h1 class="well">Welcome ${user.firstname} to Gapp</h1>

<c:if test="${size ne 0}">
<table class="table table-striped">


<tr><th>Department name</th><th>Program Name</th><th>Date Submitted</th><th>Term</th><th>Status</th><th>Action</th></tr> 
<c:forEach items="${applications}" var="appln" varStatus="status">
<tr>
<c:if test="${user.id eq appln.user.id}">

<c:forEach items="${departments}" var="d">
<c:if test="${d.id eq appln.department.id}">
<td>${d.departmentname}</td>
</c:if>
</c:forEach>
<c:forEach items="${programs}" var="p">
<c:if test="${p.id eq appln.program.id}">
<td>${p.programname}</td>
</c:if>
</c:forEach>

<td>${appln.completedate}</td>
<td>${appln.term}</td>
<td>${appln.status}</td>
<c:choose>
<c:when test="${appln.status eq 'submitted'}">
<td><a class="btn btn-primary btn-lnk" href="applicationdetails.html?applicationid=${appln.id}">View Details</a></td>
</c:when>
<c:otherwise>
<td><a class="btn btn-primary btn-lnk" href="editapplication.html?applicantid=${appln.applicant.id}&applicationid=${appln.id}">Edit</a></td>
</c:otherwise>
</c:choose>
<tr>
</c:if>
</c:forEach>

</table>
</c:if>
<a class="btn btn-default btn-lnk" href="NewApplication.html?id=${user.id}">Start A New Application</a><br />
<a  class="btn btn-default btn-lnk" href="login.html">Logout</a>

</body>
</html>