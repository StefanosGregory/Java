<%@ page import = "net.servlets.LoginServlet" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/seller_page.css">

<title>Seller Page</title>
</head>
<body>
  <ul>

    <li class="dropdown">
      <a href="seller_register_client.jsp" class="dropbtn">Register Client</a>
  </li>

    <li class="dropdown">
      <a href="ClientsViewServlet" class="dropbtn">Edit Client</a>
  </li>

    <li class="dropdown">
      <a href="ClientsViewDeleteServlet" class="dropbtn">Delete Client</a>
    </li>

    <li class="dropdown">
      <a href="ClientsViewBillsServlet" class="dropbtn">Client's Bill</a>
  </li>

    <li>
      <a href="login.jsp">Logout</a>
    </li>

  </ul>
<br><br>
  <form class="form1">
    <div class="container"> 
  	<% session = request.getSession();%>
    <% Object username = session.getAttribute("username"); %>
    <% session.setAttribute("username",username);%>
      <h1 class="register">Welcome <% out.print(username); %>, </h1>
      <hr>
      <label id="p1">Navigate on navigation bar!</label>


    </div>
  </form>



</body>
</html>
