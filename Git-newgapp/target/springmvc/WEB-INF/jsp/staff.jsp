<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff</title>
</head>
<body>
Welcome Staff.
<form action="FileUploadHandler.html" method="POST" enctype="multipart/form-data">
File :<input type="file" name="file"  /><br/>
<input type="hidden" name="userid" value="${user.id}">
<input type="submit" value="Upload" />
</form>

<a href="login.html">Logout</a>
</body>
</html>