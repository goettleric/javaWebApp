<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Delete Movie</title>
	<meta name="description" content="This is the page for deleting movies to the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Delete Movie</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<form action="DeleteMovie">
				<p>Please enter the title of the movie to delete</p>
				<label for="title"><strong>Title</strong></label>
				<input type="text" id="title" name="title" required="required" placeholder="Please no special characters">
				
				<input type="submit" id="submit" value="Delete Movie!">
			</form>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>