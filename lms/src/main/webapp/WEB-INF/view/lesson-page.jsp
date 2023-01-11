<%@page import="com.maytech.lms.entitty.Lesson"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<%
	Lesson lesson = (Lesson) request.getAttribute("lesson");
	int nextLessonId = lesson.getId() + 1;
	pageContext.setAttribute("nextLessonId", nextLessonId);
	
	int previousLessonId = lesson.getId() - 1;
	pageContext.setAttribute("previousLessonId", previousLessonId);
	%>
	<h1>Learning the basic</h1>
	<h3>${lesson.name }</h3>

	<h4>${lesson.text }</h4>
	<div align="center">${lesson.link }</div>
	<c:if test="${nextLessonId <=lessonCount.lastLessonNumber }">
	<div align="right"><a href="/lms/openLesson?id=${nextLessonId}">next lesson</a></div>
	</c:if>
	<c:if test="${previousLessonId >=lessonCount.fistLessonNumber }">
	<div align="left"><a href="/lms/openLesson?id=${previousLessonId}">previous lesson</a></div>
	</c:if>
</body>
</html>