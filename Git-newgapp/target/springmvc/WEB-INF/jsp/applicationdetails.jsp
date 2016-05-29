<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<h1><center>Application Details</center></h1>

<body>

<div class="panel panel-default">
  <div class="panel-heading">Personal Information</div>
<c:forEach items="${applications}" var="a">
<c:if test="${applicationid.id eq a.id}">
<table class="table table-striped">
<c:forEach items="${users}" var="u">
<c:if test="${u.id eq a.user.id}">

<tr><td>Name </td><td> ${u.firstname} ${u.lastname}</td></tr>
</c:if>
</c:forEach>

<c:forEach items="${applicants}" var="aplcnt">
<c:if test="${aplcnt.id eq a.applicant.id}">
<br />
<tr><td>Date of Birth</td><td>
<fmt:formatDate value="${aplcnt.dateofbirth}" pattern="yyyy-MM-dd" /></td></tr>
<tr><td>citizenship</td><td> ${aplcnt.citizenship}</td></tr>
<tr><td>
Phonenumber </td><td> ${aplcnt.phonenumber}</td></tr>
<tr><td>
Gender </td><td> ${aplcnt.gender }</td></tr>
<tr><td>
GPA </td><td> ${aplcnt.gpa}</td></tr>
<tr><td>
Toefl </td><td> ${aplcnt.toefl}</td></tr>
<tr><td>
Gre </td><td>${aplcnt.gre }</td></tr>
<tr><td>
type </td><td>${aplcnt.type }</td></tr>
<tr><td>
File </td><td><a href="download.html?name=${aplcnt.transcript}">${aplcnt.transcript}</a></td></tr>
</c:if>
</c:forEach>

<c:forEach items="${departments}" var="d">
<c:if test="${d.id eq a.department.id}">
<tr><tD>Department applied to </tD><td> ${d.departmentname}</td></tr>
</c:if>
</c:forEach>

<c:forEach items="${programs}" var="p">
<c:if test="${p.id eq a.program.id}">
<tr><td>Program Selected </td><td> ${p.programname}</td></tr>
</c:if> 
</c:forEach>
</table>



  
</div>


<div class="panel panel-default">
  <div class="panel-heading">Educational Degrees</div>


<table class="table table-striped">
<tr><th>College name</th><th>Degree Name</th><th>Major</th><th>Start Date</th><th>End Date</th><th>Graduation Date</th></tr>
<c:forEach items="${educationalbackgrounds}" var="eb" varStatus="status">
<c:if test="${eb.application.id eq a.id && eb.applicant.id eq a.applicant.id}">

<tr><td>${eb.collegename}</td>
<td>${eb.degree}</td>
<td>${eb.major}</td>
<td><fmt:formatDate value="${eb.startdate}" pattern="yyyy-MM-dd" /></td>
<td><fmt:formatDate value="${eb.enddate}" pattern="yyyy-MM-dd" /></td>
<td><fmt:formatDate value="${eb.degreeearneddate}" pattern="yyyy-MM-dd" /></td></tr>
</c:if>
</c:forEach>
</table>
</div>


<div class="panel panel-default">
  <div class="panel-heading">Additional Fields</div>

<table class="table table-responsive">
<tr><th>Name</th><th>Value</th></tr>
<c:forEach items="${af}" var="av">
<c:if test="${av.department.id eq a.department.id}">
<c:forEach items="${afv}" var="s">
<c:if test="${s.applicant.id eq a.applicant.id && s.additionalfield.additionalfield eq av.additionalfield}">
<c:if test="${a.applicant.id eq s.applicant.id && a.id eq s.application.id}">
<tr><td>${av.additionalfieldname}</td>
<c:choose>
<c:when test="${av.additionalfieldtype eq 'File'}">
<td><a href="download.html?name=${s.value}">${s.value}</a></td></tr>
</c:when>
<c:otherwise>
<td>${s.value}</td></tr>
</c:otherwise>
</c:choose>
</c:if>
</c:if>
</c:forEach>
</c:if>
</c:forEach>


</c:if>
</c:forEach>
</table>
</div>
<center>
<a class="btn btn-primary btn-lnk" href="login.html">Logout</a>
<a class="btn btn-primary btn-lnk" href="student.html?user=${applicationid.user.id}">Go Back</a></center>
</body>


</html>