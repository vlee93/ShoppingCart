<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/additional-methods.min.js"></script>
<title>Login</title>
</head>
<body>

<jsp:include page="./header.jsp"/>

<div class="jumbotron" align = "center">
  <h1> Welcome to ShopMe</h1>      
  <p>ShopMe is the one-stop shop for everyone's back-to-school shopping list.</p>
  <p> Please login or create an account in order to make a purchase.</p>
</div>


<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty error}">
	<p> ${error} </p>
</c:if>

<c:if test="${not empty loggedout}">
	<p> ${loggedout} </p>
</c:if>

<div align="center">
<form action="Login" method="post">
<label >Username: </label>
<input  type="text" name="username" ><br>
<label >Password: </label>
<input  type="password" name="password" ><br>
<input type="submit" value="Login" id="submit"><br>
<a href="CreateAccount.jsp" class="btn btn-info" role="button">Create Account</a>
</form>
</div>

</body>
</html>