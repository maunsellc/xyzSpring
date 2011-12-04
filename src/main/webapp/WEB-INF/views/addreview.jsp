<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<head>
	<link rel="stylesheet" type="text/css" href="xyzStyle.css"/>
	<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="JSON2.js"></script>	
	<script type="text/javascript">
	$(function(){
		$('.create').click(function() {
			/* prepare javascript object for JSON serialization */
			var data = { albumId: "${album}", review: $('#review').val(), name: "${member}" };
			/* use jQuery to send a RESTful POST to create a new entry */
			$.ajax({
  				url: 			'db/review',
  				type:			"POST",
  				data:			JSON.stringify(data),
  				contentType:	"application/json",
  				success: function() {
    				alert("your review was added successfully !");
    				history.back();
  				},
  				error: function(jqXHR, textStatus, errorThrown) {
					alert("error: "+textStatus+", "+errorThrown);
				},
			});
			return false;
		});		
	});
	</script>
</head>
<BODY>
<FORM>
<P align="center">
<TABLE>
<CAPTION><b>Add Review for ${title}</b></CAPTION>
<TR><TD>
</TD></TR>
<TR><TD>
<P>Review<BR><textarea id="review" name = review cols=30 rows=8></textarea></P>
</TD></TR>
</TABLE>
</P>
<P align="center">
<INPUT type="submit" value="Add" name="Add" class="create">
</P>
<TABLE>
<TR><TD>&nbsp</TD></TR><BR>
</TABLE>
<div align="center"><A href="albums.html" target="main">Return to Albums</A></div>
</FORM>
</BODY>
</HTML>
