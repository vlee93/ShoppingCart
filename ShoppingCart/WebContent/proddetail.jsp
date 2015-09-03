<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Product Detail</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="./header.jsp"/>

${message}
  
  <c:choose>
  <c:when test = "${not empty user}">
  <form role="form" action="ShopCart" method="post">
  <div class="form-group col-sm-3 col-sm-offset-9">
    <label for="QTY">Quantity:</label>
    <input type="text" class="form-control" name="QTY">
  </div>
	<button type="submit" value="Add" class="btn btn-default col-sm-3 col-sm-offset-9">Add to Cart</button>
</form>

<h3> Enter a Review:</h3>
<a href="NewReview.jsp" class="btn btn-info" role="button">Enter a Review</a>
	
  </c:when>
  <c:otherwise>
  <h4> Please log in/create an account to purchase and/or make a review </h4>
  </c:otherwise>
  </c:choose>
  

<div class="container">
<h3> Reviews:</h3>
  <p>The following are reviews by customers:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Username</th>
        <th>Review</th>
        <th>Rating</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>

<c:forEach var="comm" items="${comments}">
<tr>
<td><c:out value="${comm.shopuser.username}"/></td>
<td><c:out value="${comm.itemcomment}"/></td>
<td><c:out value="${comm.rating}"/></td>
<td><c:out value="${comm.commentdate}"/></td>
</tr>
</c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>