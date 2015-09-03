<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pay</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="./header.jsp"/>

<h3> Please enter the following information: </h3>
<form action="Payment" method="post">
<label> Shipping Address: </label>
<input  type="text" name="shipping" ><br>
<label> Billing Address: </label>
<input  type="text" name="billing" ><br>
<label> Credit Card Number: </label>
<input  type="text" name="creditcard" ><br>
<input type="submit" value="Purchase" id="submit"><br>
</form>

</body>
</html>