<!DOCTYPE html>
<html>
<% 
	if(session != null){
	session.invalidate();} 
%>
<head>
  <link rel="stylesheet" type="text/css" href="css/login.css">
<title>Welcome login</title>
</head>
<body>
<br><br>
<h1>Welcome,</h1>
<br>

 <form action="<%=request.getContextPath()%>/login" method="post">	
	<input type = "hidden" name ="requestType" value ="Login"/>
	<div class="login">
	  <br>
	  <input type="text" name="username" placeholder="Username" required>
	  <br>
	  <input type="password" name="password" placeholder="Password" required>
	  <br><br>
	  <input type="submit" value="Login">
	  <br> <br>
	</div>
</form>

</body>
</html>