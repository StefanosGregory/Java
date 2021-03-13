<%@ page import = "net.servlets.LoginServlet" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/admin_page.css">

<title>Admin Page</title>
</head>
<body>
  <ul>

    <li class="dropdown">
      <a class="dropbtn">Register</a>
    <div class="dropdown-content">
      <a href="admin_register_client.jsp">Client</a>
      <a href="admin_register_seller.jsp">Seller</a>
      <a href="admin_register_admin.jsp">Admin</a>
    </div>
  </li>

    <li class="dropdown">
      <a class="dropbtn">Edit Profile</a>
    <div class="dropdown-content">
      <a href="AdminClientsViewServlet">Client</a>
      <a href="AdminSellersViewServlet">Seller</a>
    </div>
  </li>

    <li class="dropdown">
      <a  class="dropbtn">Delete Profile</a>
      <div class="dropdown-content">
        <a href="AdminClientsViewDeleteServlet">Client</a>
        <a href="AdminSellerViewDeleteServlet">Seller</a>
      </div>
    </li>

    <li class="dropdown">
      <a  class="dropbtn">Plan</a>
      <div class="dropdown-content">
        <a href="admin_create_plan.jsp">Create</a>
        <a href="PlansViewServlet">Edit</a>
        <a href="PlansViewDeleteServlet">Delete</a>
      </div>
    </li>

    <li>
      <a href="login.jsp">Logout</a>
    </li>

  </ul>
  <br>
  <form class="form1">
    <div class="container">
      	<% session = request.getSession();%>
    <% Object username = session.getAttribute("username"); %>
    <% session.setAttribute("username",username);%>
      <h1 class="register">Welcome <% out.print(username); %>, </h1>
      <hr>
      <label id="p1">Have a good day!</label>


    </div>
  </form>



</body>
</html>
