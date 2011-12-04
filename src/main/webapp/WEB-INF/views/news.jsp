<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${fn:length(news) gt 0}">
<TABLE width=100% border=0>
<TR><TD bgcolor=black><font color=white><b><div align="center">NEWS</div></b></font></TD></TR>
<c:forEach var="item" items="${news}">
<TR><TD bgcolor=silver>
<font size=2><b>
<P>
${item.title}<BR>
</P></b>
${item.date}<BR>
</font></TD></TR>
</c:forEach>
</TABLE>
</c:when>
<c:otherwise>
<P align="center">Sorry, no news found !</P>
</c:otherwise>
</c:choose>
</body>
</html>