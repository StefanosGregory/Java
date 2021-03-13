<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/client_page.css">

<title>Welcome</title>
</head>
<body>
     	<% session = request.getSession();%>
    <% Object username = session.getAttribute("username"); %>
    <% session.setAttribute("username",username);%>
  <ul>
    <li class="dropdown">
      <a href="ClientYourBillsServlet?username=<%out.print(username);%>">Your Bills</a>
  </li>

    <li>
      <a href="login.jsp">Logout</a>
    </li>

  </ul>
  <br>
  <br>

    <form class="form1">
      <div class="container">

      <h1 class="register">Welcome <% out.print(username); %>, </h1>
        <hr>
        <label id="p1">Please feel free to use ours page for your needs.</label>


      </div>
    </form>

  </body>
  </html>
