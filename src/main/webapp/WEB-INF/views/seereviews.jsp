<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<c:choose>
<c:when test="${fn:length(reviews) gt 0}">
<TABLE width=100% border=0>
<TR><TD bgcolor=black><font color=white><b><div align="center">REVIEWS for ${title}</div></b></font></TD></TR>
<c:forEach var="review" items="${reviews}">
<TR><TD bgcolor=silver>
<P>${review.review}<P><BR>
</TD></TR>
<TR><TD bgcolor=silver><DIV align="right">${review.name}</DIV>
</TD></TR>
</c:forEach>
</TABLE>
</c:when>
<c:otherwise>
<P align="center">Sorry, no reviews found !</P>
</c:otherwise>
</c:choose>
</body>
</html>