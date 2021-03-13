<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/seller_register_client.css">

<title>Register Client</title>
</head>
<body>
  <ul>

    <li class="dropdown1">
      <a class="dropbtn1">Register Client</a>
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

  	<%	session = request.getSession();%>
    <% Object username = session.getAttribute("username"); %>
    <% session.setAttribute("username",username);%>
<br><br>
  <form action="<%=request.getContextPath()%>/RegisterClientServlet" method="post"class="form1">
    <div class="container">
      <h1 class="register">Register a Client, </h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username" id="username" required>

      <label for="name"><b>Name</b></label>
      <input type="text" placeholder="Enter Name" name="name" id="name" pattern="[A-Za-z]{1,20}" required>

      <label for="surname"><b>Surname</b></label>
      <input type="text" placeholder="Enter surname" name="surname" id="surname" pattern="[A-Za-z]{1,20}" required>

      <label for="afm"><b>Afm</b></label>
      <input type="text" placeholder="Enter Afm" name="afm" id="afm" pattern="[0-9]{1,10}" required>


      <label for="plan"><b>Plan</b></label>
      <br><br>
      <form>
      <input type="radio" id="plan1" name="plan" value="1">
      <label for="plan1">Plan </label><label class="plan">I</label><br>
      <input type="radio" id="plan2" name="plan" value="2">
      <label for="plan2">Plan </label><label class="plan">II</label><br>
      <input type="radio" id="plan3" name="plan" value="3">
      <label for="plan3">Plan </label><label class="plan">III</label><br>
     </form>
      <br>

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
