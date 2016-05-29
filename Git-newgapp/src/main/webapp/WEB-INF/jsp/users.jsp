<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>Users</title></head>
<body>
<table>
<tr><th>ID</th><th>Username</th><th>Enabled</th></tr>
<c:forEach items="${users}" var="user">
<tr>
  <td>${user.id}</td>
  <td>${user.firstname}</td>
  <td><a href="view.html?id=${user.id }">View</a>
  
</tr>
</c:forEach>
</table>
<a href="add.html">Add new user</a><br />
<a href="login.html">Logout</a>

</body>
</html>