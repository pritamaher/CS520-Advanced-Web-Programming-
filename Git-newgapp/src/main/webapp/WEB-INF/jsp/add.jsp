    
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<nav class="navbar navbar navbar-inverse">
  <div class="container">
<center><p class="navbar-text navbar-center"><a href="add.html" style="color: #ffffff"><font size="10">
<center>GAPP Sign Up</center></font>
</a></center><br />

  </div>
</nav>

<form:form modelAttribute="user">
    
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <center ><div class="panel-title">Sign Up</div></center>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                          
                          <form:form modelAttribute="user" class="form-horizontal" role="form">
                            
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                  <span class="input-group-addon">First Name</i></span>
								
                         	 <form:input path="firstname" placeholder="First Name" class="form-control" type="text"/> <form:errors path="firstname"/><br/>
                          
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">Last Name</i></span>
								
                      				 <form:input path="lastname" placeholder="Last Name" class="form-control" type="text"/> <form:errors path="lastname"/><br/>
    
                      
                                    </div>

                         
                            <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">Password</i></span>
								
									<form:input path="password" placeholder="password" class="form-control" type="text"/> <form:errors path="password"/><br/>

                                    </div>
                        
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon">Email Id</i></span>
								<form:input type="email" path="emailid" placeholder="example@localhost.localdomain" class="form-control" /> <form:errors path="emailid"/><br/>

                                    </div>
                                
                         
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
							<tr><td><center>    <input id="btn-login"  class="btn btn-success" type="Submit" name="add" value="add"></center></td></tr>
                                      
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Go to login Page
                                             
                                        <a href="login.html" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Login
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form:form>     



                        </div>                     
                    </div>  
        </div>

                                    </form:form>
</body>
</html> 