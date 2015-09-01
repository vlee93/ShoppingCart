<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="ProdList">ShopMe</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="ProdList">Our Products
        <li><a href="ShopCart">My Cart</a></li>
      </ul>
    </div>
  </div>
</nav>

${message}

<form role="form" action="ShopCart" method="post">
  <div class="form-group col-sm-3 col-sm-offset-9">
    <label for="QTY">Quantity:</label>
    <input type="text" class="form-control" name="QTY">
  </div>
  <button type="submit" value="Add" class="btn btn-default col-sm-3 col-sm-offset-9">Add to Cart</button>
</form>

</body>
</html>