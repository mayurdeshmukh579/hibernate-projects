<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Instructor List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<%@ include file="menu.jsp"%>

	<br>
	<div class="container">

		<div align="right">
			<form:form action="process-search" method="GET"
				modelAttribute="SearchDTO">

				<label>Search Instructor: </label>
				<form:input path="id" />
				<input type="submit" value="search">

			</form:form>
			<br />
			<div>
				<a href="/lms/instructor-info">Refresh list</a>
			</div>
			<br>
		</div>
		<div class="container">

			<table class="table table-bordered">
				<thead class="table-secondary">
					<tr>
						<th>id</th>
						<th>Name</th>
						<th>Experiance Year</th>
						<th>Email</th>
						<th>Courses</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="instructor" items="${instructorList}">
						<tr>
							<td>${instructor.id}</td>
							<td>${instructor.name}</td>
							<td>${instructor.teachingexp}</td>
							<td>${instructor.email}</td>
							<td>
								<table class="table">
									<thead class = "table-info">
										<tr>
											<th>name</th>
											<th>duration</th>
										</tr>

									</thead>
									<tbody>
										<c:forEach var="course" items="${instructor.courses}">
											<tr>
												<td>${course.name }</td>
												<td>${course.duration }</td>
												<td><a href="/lms/viewCourse?courseId=${course.id }">view</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</td>
							<td><a href="/lms/deleteInstructor?id=${instructor.id}"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

				</div>

			</table>
</body>
</html>