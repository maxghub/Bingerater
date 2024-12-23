<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify OTP</title>
</head>
<body>
<form action="otpVerification" method="post">
<input type = "hidden" name="email" value="${ email }">

<input type = "hidden" name="mov_id" value="${ mov_id_t }">

<input type = "text" placeholder="Enter OTP" name="otp">
<button type="Submit">Submit OTP</button>
</form>

</body>
</html>