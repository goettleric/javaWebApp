<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Error Page</title>
	<meta name="description" content="This is the 500 error page for the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>500 Error</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<p><strong>Server Is Down</strong>
			<p>The Web server encountered a problem that prevented it from fulfilling the request.</p>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>