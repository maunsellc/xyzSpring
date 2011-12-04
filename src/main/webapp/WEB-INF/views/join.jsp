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
		$('.create').click(function() {
			/* prepare javascript object for JSON serialization */
			var data = { name: $('#name').val(), email: $('#email').val(), address: $('#address').val(), homepage: $('#homepage').val(), password: $('#password').val(), };
			/* use jQuery to send a RESTful POST to create a new entry */
			$.ajax({
  				url: 			'db/member',
  				type:			"POST",
  				data:			JSON.stringify(data),
  				contentType:	"application/json",
  				success: function() {
    				alert("your membership was approved !");
    				history.back();
  				},
  				error: function(jqXHR, textStatus, errorThrown) {
					alert("invalid login/passsword");
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
<H2>Member Join</H2>
<TR><TD>
<P>Name<BR><INPUT type="text" id="name" name="name" value=""></P>
</TD></TR>
<TR><TD>
<P>Email<BR><INPUT type="text" id="email" name="email" value=""></P>
</TD></TR>
<TR><TD>
<P>Address<BR><INPUT type="text" id="address" name="address" value=""></P>
</TD></TR>
<TR><TD>
<P>Homepage<BR><INPUT type="text" id="homepage" name="homepage" value=""></P>
</TD></TR>
<TR><TD>
<P>Password<BR><INPUT type="password" id="password" name="password" value=""></P>
</TD></TR>
</TABLE>
</P>
<P align="center">
<INPUT type="submit" class="create" name="join" value="Join">
</P>
</FORM>
</BODY>
</HTML>
