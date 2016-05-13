<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Index</title>
	<meta name="description" content="This is the home page for the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Welcome to the Movie Home Page</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			
			<p>Movies are a great way to sit back and relax.  For me some of the best movies are the ones I grow up with.</p>
		</article>
	</div>
</body>
<hr>
<p>If movies need to be added from the file, populate the database first by clicking the button
<a href="populateDatabase.jsp"><button>Populate Database Here</button></a></p>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>