<!DOCTYPE html >
<html>
<head>
	<title>Movie Application: Add Movie</title>
	<meta name="description" content="This is the page for adding movies to the Movie Website">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<header>
			<h1>Add Movie</h1>
		</header>
		<hr>
		<%@include file="includes/navigation.jsp" %>
		<hr>
		<article>
			<form action="addMovie">
				<label for="title"><strong>Title</strong></label>
				<input type="text" id="title" name="title" required="required" placeholder="Please no special characters">
				
				<label for="releaseDate"><strong>Release Date</strong></label>
				<input type="text" id="releaseDate" name="releaseDate" required="required" placeholder="mm/dd/yyyy or click to enter">
				
				<label for="lengthInMinutes"><strong>Length In Minutes</strong></label>
				<input type="number" id="lengthInMinutes" step= "1" min="1" name="lengthInMinutes" required="required">
				
				<label for="genre"><strong>Genre</strong></label>
				<input type="text" id="genre" name="genre" required="required" placeholder="Action/Adventure/Drama/etc.">
				
				<label for="leadActor"><strong>Lead Actor/Actress</strong></label>
				<input type="text" id="leadActor" name="leadActor" required="required" placeholder="First name/Last name">
				
				<label for="director"><strong>Director</strong></label>
				<input type="text" id="director" name="director" required="required" placeholder="First name/Last name">
				
				<p>Image source paths can be added by going to IMBD.com and copying the image location off the movie poster and pasting it in the text field below.<p>
				<a href="http://www.imdb.com">IMDb</a>
				
				<label for="pictureLink"><strong>Picture Link</strong></label>
				<input type="url" id="pictureLink" name="pictureLink" pattern="http://ia.media-imdb.com/images/.+.jpg" placeholder="http://ia.media-imdb.com/images/" required="required">
				
				<input type="submit" id="submit" value="Add Movie!">
			</form>
		</article>
	</div>
</body>
<hr>
<%@include file="includes/scripts.jsp" %>
<%@include file="includes/footer.jsp"%>
</html>