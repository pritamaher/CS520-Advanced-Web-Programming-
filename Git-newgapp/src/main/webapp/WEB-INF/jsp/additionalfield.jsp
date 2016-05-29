<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Additional Requirements</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>
<body class='container' link="#CC0000">
<h1><center>Additional Requirements</center></h1></body>
<a>If there Are No Additional Requirements For this Department Please Click the Save And Continue Button</a>
<body>
<form action="additionalfield.html" method="POST" enctype="multipart/form-data">

<table class="table table-responsive">
<c:forEach items="${af}" var="a">
<c:if test="${a.department.id eq departmentid}">

<c:if test="${a.additionalfieldtype eq 'Text'}">
<c:choose>
<c:when test="${a.choice eq 'Required'}">
<tr><td>${a.additionalfieldname}</td><td><input type="text" name="text" Required/></td></tr>
<input type="hidden" name="textname" value="${a.additionalfieldname}" />
</c:when>
<c:otherwise>
<tr><td>${a.additionalfieldname}(optional)</td><td><input type="text" name="text" /></td></tr>
<input type="hidden" name="textname" value="${a.additionalfieldname}" />
</c:otherwise>
</c:choose>




</c:if>

<c:if test="${a.additionalfieldtype eq 'Number'}">
<c:choose>
<c:when test="${a.choice eq 'Required'}">
<tr><td>${a.additionalfieldname}</td><td><input type="number" name="number" Required/></td></tr>
<input type="hidden" name="numbername" value="${a.additionalfieldname}" />

</c:when>
<c:otherwise>
<tr><td>${a.additionalfieldname}(optional)</td><td><input type="number" name="number"/></td></tr>
<input type="hidden" name="numbername" value="${a.additionalfieldname}" />

</c:otherwise>
</c:choose>



</c:if>

<c:if test="${a.additionalfieldtype eq 'File'}">
<c:choose>
<c:when test="${a.choice eq 'Required'}">
<tr><td>${a.additionalfieldname}</td><td><input type="file" name="file" Required/></td></tr>
<input type="hidden" name="filename" value="${a.additionalfieldname}" />

</c:when>
<c:otherwise>
<tr><td>${a.additionalfieldname}(optional)</td><td><input type="file" name="file" /></td></tr>
<input type="hidden" name="filename" value="${a.additionalfieldname}" />
</c:otherwise>
</c:choose>





</c:if>
</c:if>
</c:forEach>
<br />
</table>
<input type="hidden" name="appid" value="${appid}"/>
<input type="hidden" name="program" value="${pro}"/>
<input type="hidden" name="userid" value="${userid}"/>
<input type="hidden" name="applicantid" value="${applicantid}"/>
<input type="hidden" name="departmentid" value="${departmentid}"/>
<input class="btn btn-primary" type="submit" value="Save and Continue"/>


</form>
</body>
</html>