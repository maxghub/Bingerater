<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rate Your Movie</title>  
<style>
	img{
	padding-left: 500px;
	}
	body{
	background-color: skyblue;
	}
</style>
</head>
<body>
	<form action ="login">
		<div>
			<img  src=${ lst[7] } alt="Image Not Found" height="500" width="350">
			<table border =2>
				<tr>
					<th>Movie Name</th>
					<th>Year</th>
					<th>Genre</th>
					<th>Length</th>
					<th>Premise</th>
					<th>Parental Guide</th>
					<th>Average Rating(Out of 7)</th>
					<th>Total BingeRater</th>
				</tr>
				<tr>
					<td>${ lst[1] }</td>
					<td>${ lst[2] }</td>
					<td>${ lst[3] }</td>
					<td>${ lst[4] }</td>
					<td>${ lst[5] }</td>
					<td>${ lst[6] }</td>
					<td>${ lst[8] }</td>
					<td>${ lst[9] }</td>
					<input type = "hidden" name="mov_id_c" value="${ lst[0] }">
				</tr>
				
				 <div>
				 	<button> Rate Now</button>
				 </div>
				 
			</table>
		</div>
	</form>
	
</body>
</html>