<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
	<head>
		<title>XZY Fanclub</title>
		<link rel="stylesheet" type="text/css" href="xyzStyle.css"/>
		<style type="text/css">
		body {
			font-family: Arial, Helvetica;
			font-size: 12px;
		}
		</style>
	</head>
	<body style="text-align:center;">
		<security:authorize access="isAuthenticated()">
			<p>Hello <security:authentication property="principal.username"/>&nbsp;&nbsp;<a href="j_spring_security_logout">Logout</a></p>
		</security:authorize>
		<table>
		    <%-- iterate though Intros table and display each intro as raw HTML --%>
			<c:forEach var="intro" items="${intros}">
				<tr>
					<td><div class="shadowed">${intro.text}</div></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>