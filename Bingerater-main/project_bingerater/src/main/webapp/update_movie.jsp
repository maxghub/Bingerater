<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Your Movie</title>
</head>
<body>
<form action="update_rate">
	<!-- 0. current_rating
		 1. user_id
		 2. movie_id
		 3. movie_name
		 4. movie_path -->
	<img  src=${ rate[4] } alt="Image Not Found" height="500" width="350">
	<br>
	<label>Your old rating on "${ rate[3] }" was: ${ rate[0] } out of 7</label>
	<br>
	<label>New Rating: </label>
	<br>
	<input type="range" id="csd" name="point" min="1" max="7">
	<br>
	<button>Update Rating</button>
	<br>
	<input type = "hidden" name="mov_id_f" value="${ rate[1] }">
	<input type = "hidden" name="user_id_f" value="${ rate[2] }">
	<!-- 
	Rating = ${ rate[0] }
	User_id = ${ rate[1] }
	movie_id = ${ rate[2] } -->
</form>
</body>
</html>