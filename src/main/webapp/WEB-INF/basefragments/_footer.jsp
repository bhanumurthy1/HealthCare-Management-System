<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<footer class="footer mt-auto py-3" style="background-color: #055160">
  <div class="container">
    <span class="link-light">Copyright &copy <%= new SimpleDateFormat("yyyy").format(new Date()) %> Health Care Management System . All Rights Reserved.</span>
  </div>
</footer>

</body>
</html>