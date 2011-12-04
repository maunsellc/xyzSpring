<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<link rel="stylesheet" type="text/css" href="xyzStyle.css"/>
	<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="JSON2.js"></script>	
	<script type="text/javascript">
	$(function(){
		$('.update').click(function() {
			/* prepare javascript object for JSON serialization */
			var data = { email: $('#email').val(), address: $('#address').val(), homepage: $('#homepage').val(), password: $('#password').val(), };
			/* use jQuery to send a RESTful POST to create a new entry */
			$.ajax({
  				url: 			'db/member/${name}',
  				type:			"PUT",
  				data:			JSON.stringify(data),
  				contentType:	"application/json",
  				success: function() {
    				alert("your membership was updated !");
    				history.back();
  				},
  				error: function(jqXHR, textStatus, errorThrown) {
					alert("error: "+textStatus+", "+errorThrown);
				},
			});
			return false;
		});		
		$('.delete').click(function() {
			var answer = confirm  ("Are you sure you want to delete ${name}")
			if (!answer)
				return false;
			/* use jQuery to send a RESTful POST to create a new entry */
			$.ajax({
  				url: 			'db/member/${name}',
  				type:			"DELETE",
  				data:			"",
  				contentType:	"application/json",
  				success: function() {
    				alert("your membership was deleted !");
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
</HEAD>
<BODY>
<FORM>
<P align="center">
<TABLE width=50%>
<H2>Membership details</H2>
<TR><TD>
<P>Name<BR><INPUT type="text" id="name" name="name" value="${name}"></P>
</TD></TR>
<TR><TD>
<P>Email<BR><INPUT type="text" id="email" name="email" value="${email}"></P>
</TD></TR>
<TR><TD>
<P>Address<BR><INPUT type="text" id="address" name="address" value="${address}"></P>
</TD></TR>
<TR><TD>
<P>Homepage<BR><INPUT type="text" id="homepage" name="homepage" value="${homepage}"></P>
</TD></TR>
<TR><TD>
<P>Password<BR><INPUT type="password" id="password" name="password" value="${password}"></P>
</TD></TR>
</TABLE>
</P>
<P align="center">
<INPUT type="submit" class="update" name="Update" value="Update">
<INPUT type="submit" class="delete" name="Delete" value="Delete">
</P>
</FORM>
</BODY>
</HTML>
