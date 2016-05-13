<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Movie List</title>
	<meta name="description" content="This is the Movie List unsorted for a Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Movie List</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<%@include file="includes/movies.jsp" %>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>