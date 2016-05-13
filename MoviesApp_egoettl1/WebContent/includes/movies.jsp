<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:choose>
			<c:when test="${empty movies}">
				<p>Sorry, there were no results for that search.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="movie" items="${movies}">
				<img alt="${movie.title}" src="${movie.pictureLink}">
					<dl>
						<dt>${movie.title}</dt>
							<dd>Release Date: ${movie.releaseDate}<br>Directed By: ${movie.director}<br>Length: ${movie.lengthInMinutes} minutes<br>Genre: ${movie.genre}<br>
							Lead Actor/Actress: ${movie.leadActor}<dd>
					</dl>
				</c:forEach>
			</c:otherwise>
		</c:choose>