<!DOCTYPE html>
<%@page import="com.digit.hibernateServlet.bean.AadharDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Balance</title>
<!-- Link Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	padding-top: 20px;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	background-color: #fff;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.balance-info {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 20px;
}

.btn-redirect {
	background-color: #008080;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	margin-top: 20px;
}

.btn-redirect:hover {
	background-color: #006666;
}
</style>
</head>
<body>
	<div class="container">
		<h2>View All Details</h2>
		<div class="balance-info">
			<%
	session = request.getSession();
	List userList  = (List) session.getAttribute("allUser");
	Iterator  itr = userList.iterator();
	 while(itr.hasNext())
	 {
		 AadharDetails s = (AadharDetails) itr.next();
		 out.println("Aadhar Id: "  +s.getAadharId()+"<br>");
		 out.println("Name: "  +s.getName()+"<br>");
		 //out.println("Phone: "  +s.getPhone()+"<br>");
		 out.println("Email: "  +s.getEmail()+"<br>");
		 out.println("Address: "  +s.getAddress()+"<br>");
		out.println("City: "  +s.getCity()+"<br>");
		 out.println("State: "  +s.getState()+"<br>");
		 out.println("---------------------------------");
	 }
	%>
		</div>
		<a href="index.html" class="btn-redirect">Go To Home</a>
	</div>

	<!-- Link Bootstrap JS and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
