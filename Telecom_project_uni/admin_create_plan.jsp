<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/admin_create_plan.css">

<title>Plan</title>
</head>
<body>
  	<% session = request.getSession();%>
    <% Object username = session.getAttribute("username"); %>
    <% session.setAttribute("username",username);%>

  <ul>
    <li class="dropdown">
      <a class="dropbtn" href="javascript:void(0)">Register</a>
    <div class="dropdown-content">
      <a href="admin_register_client.jsp">Client</a>
      <a  href="admin_register_seller.jsp">Seller</a>
      <a href="admin_register_admin.jsp">Admin</a>
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
      <a href="javascript:void(0)" class="dropbtn1">Plan</a>
      <div class="dropdown-content">
        <a class="create">Create</a>
        <a href="PlansViewServlet">Edit</a>
        <a href="PlansViewDeleteServlet">Delete</a>
      </div>
    </li>

    <li>
      <a href="login.jsp">Logout</a>
    </li>

  </ul>

<br>
<br>

  <form action="<%=request.getContextPath()%>/PlanCreateServlet" method="post" class="form1">
    <div class="container">
      <h1 class="register">Create a Plan, </h1>
      <p>Please fill this form to create a new plan.</p>
      <hr>
      <p>Type unlimited to fields for <b class="eu" >unlimited</b> use<p>

      <label for="minutes"><b>Minutes Airtime</b></label>
      <input type="text" placeholder="Enter Minutes '" name="airtime" id="minutes" required>

      <label for="SMS"><b>SMS no.</b></label>
      <input type="text" placeholder="Enter SMS" name="sms" id="sms" required>

      <label for="data"><b>Data (Mb)</b></label>
      <input type="text" placeholder="Enter Data MB " name="data" id="data" required>

      <label for="price"><b>Price </b><b class="eu">EU</b></label>
      <input type="text" placeholder="Enter Price €" name="price" id="data" required>

      <hr>
      <button type="submit" class="registerbtn">Create</button>
    </div>
  </form>



</body>
</html>
