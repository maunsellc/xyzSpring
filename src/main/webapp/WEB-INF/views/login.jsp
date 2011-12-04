<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Sign in to XYZ fanclub</h2>
	<c:if test='${status == "invalid"}'>
	<div style="color:red">login incorrect !</div>
	</c:if>
	<form method="post" class="signin" action="j_spring_security_check">

	<fieldset> 
	<table cellspacing="0"> 
	<tr> 
	<th><label for="username">Member name</label></th> 
	<td><input id="username" name="j_username" type="text" />
	</td> 
	</tr>
	<tr> <th><label for="password">Password</label></th>
		<td><input id="password" 
				   name="j_password"
				   type="password" /> 
	    </td>
		</tr> 	
		<tr> 
		<th></th> 
		<td><input name="commit" type="submit" value="Login" /></td> 
        </tr>
		</table>
	</fieldset> 
	</form>
	<script type="text/javascript"> 
		document.getElementById('username_or_email').focus();
	</script> 
</body>
</html>