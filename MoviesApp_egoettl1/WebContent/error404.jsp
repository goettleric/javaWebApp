<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Error Page</title>
	<meta name="description" content="This is the 404 error page for the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Page Not Found</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<p><strong>Check Address</strong>
			<p>The web page resource you entered could not be found.  Web page address is incorrect or is no longer available.</p>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>