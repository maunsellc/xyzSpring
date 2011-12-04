<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XYZ</title>
<link rel="stylesheet" type="text/css" href="xyzStyle.css"/>
<style type="text/css">
body {
	font-family: Arial, Helvetica;
	font-size: 12px;
}
</style>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function loadAlbums()
	{
		/*
		** we use jQuery to perform a RESTful GET query for all albums in database
		** then we dynamically appends each album from dataset as a row in HTML table
		*/
		var count = 0;
		$.getJSON("db/albums",function(albums)
		{
			$.each(albums, function(i,album)
			{
				var tr_data =
					'<tr><td>'+album.title+'</td>'+
					'<td colspan="2" rowspan="4"><div align="right"><img width="75" height="75" src="'+album.image+'"></div></td></tr>'+
					'<tr><td>'+album.artist+'</td></tr>'+
					'<tr><td>'+album.year+'</td></tr>'+
					'<tr><td>'+album.label+'</td></tr>'+
					'<tr><td>'+album.comment+'<td></tr>'+
<security:authorize access="isAuthenticated()">
					'<tr><td><form action="vote" method="post"><b>Votes: '+album.votes+'</b><input type="hidden" name="album" value="'+album.id+'"><input type=submit value="Vote"/></form></td></tr>'+
					'<tr><td><a href="addreview.html?title='+album.title+'&album='+album.id+'&member=<security:authentication property="principal.username"/>" target="main"><font size=1>Add Review...</font></a></td></tr>'+
</security:authorize>
					'<tr><td><div align="left"><a href="seereviews.html?title='+album.title+'&album='+album.id+'" target="main"><font size=1>See Reviews...</font></a></div></td></tr>';
				$('#Albums tbody:last').append(tr_data);
				++count;
			});
			if( count > 0 )
				$('#AlbumStatus').html("Found "+count+" Albums");
			else
				$('#AlbumStatus').html("No albums found !");
		});
	}
	$(document).ready(function()
	{
		/* pretend that loading albums takes a long time */
		setTimeout("loadAlbums()", 2000);
		return false;
	});
</script>
<title></title>
</head>
<body>
	<div style="align: center">
		<div id="AlbumStatus">Loading albums...</div>
		<table style="background-color: silver; width: 60%;" id="Albums">
			<tbody></tbody>
		</table>
	</div>
</body>
</html>