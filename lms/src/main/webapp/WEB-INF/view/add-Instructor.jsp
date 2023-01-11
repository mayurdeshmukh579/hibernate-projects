<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Instructor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<%@ include file="menu.jsp" %>

<h1>Add Instructor</h1>
<form:form action="submit-instructor" method="POST" modelAttribute="instructor">
<div align="center">
<label>Name :</label>
<form:input path="name"/>
</div>
<br>
<div>
<label>Teaching Experiance</label>
<form:input path="teachingexp"/>
</div>
<br>
<label>Email</label>
<form:input path="email"/>
<br>
<input type="submit" value="Add">


</form:form>
</body>
</html>