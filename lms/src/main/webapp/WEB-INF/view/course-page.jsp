<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${course.name}</h1>
	<hr>
	<h3>Lessons</h3>
	<c:forEach var="lesson" items="${course.lessons }">
	<a href="/lms/openLesson?id=${ lesson.id}">${lesson.name}</a>
</c:forEach>
</body>
</html>