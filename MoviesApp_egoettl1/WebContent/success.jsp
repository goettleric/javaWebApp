<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Success Page</title>
	<meta name="description" content="This is the success page for successfully addition to the Movie database for the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Success!</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<p>${success}</p>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>