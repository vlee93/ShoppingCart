<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="ProdList">ShopMe</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="ProdList">Our Products

      <c:choose>
      <c:when test = "${not empty user}">
      <li><a href="ShopCart">My Cart</a></li>
      <li><a href="Past">Past Purchases</a></li>
      </ul>
       <ul class="nav navbar-nav navbar-right">
       <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout   .</a></li>
      </ul>
      </c:when>
      <c:otherwise>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <li><a href="ShopLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Login   .</a></li>
      </ul>
      </c:otherwise>
      </c:choose>
      
      <c:choose>
      	<c:when test = "${user.usertype == 'admin'}">
      	<ul class="nav navbar-nav">
      	<li><a href="Credit">Add Credit to User</a></li>
     	<li><a href="AllCart">See All Cart</a></li>
      	</ul>
      	</c:when>
      	<c:otherwise>
      	
      	</c:otherwise>
      </c:choose>
      
      
      
    </div>
  </div>
</nav>