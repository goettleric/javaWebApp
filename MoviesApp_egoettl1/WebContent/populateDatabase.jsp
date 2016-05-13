<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Populate Database</title>
	<meta name="description" content="This is for populating the Movie database for a Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Populate Database</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<form action="PopulateDatabase" method="post">
				<input type="submit" name="populate" value="Populate!">
			</form>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>