<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Search</title>
	<meta name="description" content="This is the search page for the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Search</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<form action="MovieSearch">
				<label for="title"><strong>Search By Title</strong></label>
				<input name="title" placeholder="title" required="required">
				<input type="hidden" name="searchType" value="title">
				<input type="submit" id="submit" value="Search!">
			</form>
			<form action="MovieSearch">
				<label for="director"><strong>Search By Director</strong></label>
				<input name="director" placeholder="first name/last name" required="required">
				<input type="hidden" name="searchType" value="director">
				<input type="submit" id="submit" value="Search!">
			</form>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>