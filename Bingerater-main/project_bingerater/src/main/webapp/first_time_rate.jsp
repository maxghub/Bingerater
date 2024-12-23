<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rate your first movie</title>
</head>
<body>
<form action="first_rate">
	<!-- 0. id
		 1. movie_id
		 2. movie_name
		 3. movie_path 
	 -->
	<img  src=${ rate[3] } alt="Image Not Found" height="500" width="350">
	<br>
	<label>You can Rate Upto 7 points for ${ rate[2] }</label>
	<br>
	<label>Rating Point: </label>
	<br>
	<input type="range" id="csd" name="point" min="1" max="7">
	<br>
	<button>Submit</button>
	<input type = "hidden" name="user_id_f" value="${ rate[0] }">
	<input type = "hidden" name="mov_id_f" value="${ rate[1] }">
</form>
</body>
</html>