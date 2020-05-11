<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>
<c:if test='${empty sessionScope["Spotify-token"]}'>
    <c:redirect url = "/AuthController/Spotify"/>
</c:if>

<h1>Spotify playlist creation</h1>
<div class="container">

    <p class="message"></p>

    <form action="/spotifyPlaylistNew" method="post">

        <label for="name">Name:</label>
        <textarea id="name" name="name"></textarea>

        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea>

        <div class="bottom_links">
            <button type="submit" class="button">Create playlist in Spotify</button>
            <button type="button" onClick="javascript:window.location.href = '/'" class="button">Cancel</button>
        </div>
    </form>
</div>

<%@include file="includes/footer.jsp"%>
