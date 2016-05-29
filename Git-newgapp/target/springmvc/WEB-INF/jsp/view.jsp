
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>Users</title></head>
<body>
<table>
<tr><th>ID</th><th>Username</th><th>Password</th></tr>
  <td>${user.id}</td>
  <td>${user.firstname}</td>
  <td>${user.password }</td>
  
</table>
</body>
</html>