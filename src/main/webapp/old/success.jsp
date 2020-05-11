<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>


<fieldset id="omdb">
<legend>OMDb search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.movies}" var="movie">
	<span>Movie title: <c:out value="${movie.title}"/></span><br/>
</c:forEach>
</fieldset>

<fieldset id="flickr">
<legend>Flickr search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.photos.photo}" var="photo">
	<img src ='http://farm<c:out value="${photo.farm}"/>.staticflickr.com/<c:out value="${photo.server}"/>/<c:out value="${photo.id}"/>_<c:out value="${photo.secret}"/>.jpg'/>
</c:forEach>
</fieldset>

<fieldset id="lyrics">
<legend>Lyrics search for <c:out value="${param.searchQuery}"/></legend>
	${lyrics}
</fieldset>

<fieldset id="events">
<legend>Events search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.events}" var="event">
	<c:out value="${event.city_name}"/> - <a href="${event.url}">More info</a> </br>
</c:forEach>
</fieldset>


<video controls autoplay name="media">
	<source src="<c:out value="${previewUrlCancion}"/>" type="audio/mpeg">
</video>

</body>
</html>