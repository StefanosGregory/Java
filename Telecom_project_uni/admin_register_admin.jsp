<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/admin_register_admin.css">

<title>Register</title>
</head>
<body>

  	<% session = request.getSession();%>
    <% Object username = session.getAttribute("username"); %>
    <% session.setAttribute("username",username);%>
  <ul>
    <li class="dropdown">
      <a class="dropbtn1" href="javascript:void(0)">Register</a>
    <div class="dropdown-content">
      <a href="admin_register_client.jsp">Client</a>
      <a href="admin_register_seller.jsp">Seller</a>
      <a class="admin">Admin</a>
    </div>
  </li>

    <li class="dropdown">
      <a href="javascript:void(0)" class="dropbtn">Edit Profile</a>
    <div class="dropdown-content">
      <a href="AdminClientsViewServlet">Client</a>
      <a href="AdminSellersViewServlet">Seller</a>
    </div>
  </li>

    <li class="dropdown">
      <a href="javascript:void(0)" class="dropbtn">Delete Profile</a>
      <div class="dropdown-content">
        <a href="AdminClientsViewDeleteServlet">Client</a>
        <a href="AdminSellerViewDeleteServlet">Seller</a>
      </div>
    </li>

    <li class="dropdown">
      <a href="javascript:void(0)" class="dropbtn">Plan</a>
      <div class="dropdown-content">
        <a href="admin_create_plan.jsp">Create</a>
        <a href="PlansViewServlet">Edit</a>
        <a href="PlansViewDeleteServlet">Delete</a>
      </div>
    </li>

    <li>
      <a href="#Logout">Logout</a>
    </li>

  </ul>

<br>
<br>

  <form  action="<%=request.getContextPath()%>/AdminRegisterServlet" method="post" class="form1">
    <div class="container">
      <h1 class="register">Register an Admin, </h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username" id="username" required>

      <label for="name"><b>Name</b></label>
      <input type="text" placeholder="Enter Name" name="name" id="name" required>

      <label for="surname"><b>Surname</b></label>
      <input type="text" placeholder="Enter surname" name="surname" id="surname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

      <label for="psw-repeat"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="psw2" id="psw-repeat" required>
      <hr>
      <p>By creating an account you agree to our <a class="hprlink" href="#">Terms & Privacy</a>.</p>

      <button type="submit" class="registerbtn">Register</button>
    </div>
  </form>



</body>
</html>
