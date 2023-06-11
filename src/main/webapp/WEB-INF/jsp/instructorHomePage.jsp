<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Instructor Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
    
  </head>
  <body>
   <nav class="navbar "style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="instructorHomePage.jsp">
      <img src="https://www.taashee.com/wp-content/uploads/2023/02/taashee-logo-1000-x-2001.png" alt="Logo" width="280" height="60" class="d-inline-block align-text-top" style="margin-top: -20px">
      <span class="fs-1 fw-bold">T</span><span class="fs-3 " style="color:#61CE70">raining</span><span class="fs-1 fw-bold">A</span><span  class="fs-3" style="color:rgb(113,206,126)">cademy</span>
    </a>
    <div  class="nav-item dropdown" style="margin-left:340px">
    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <button type="button" class="btn btn-success">Instructor Quick Actions</button>
          </a>
  		<ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/addUser">Add a Student</a></li>
            <li><a class="dropdown-item" href="/getAssignCourseForm">Assign Course to Student</a></li>
          </ul>
    </div>
    <div   style="margin-right:100px">
    <a  href="/logout"  >
           <button type="button" class="btn btn-danger">Logout<i class="bi bi-box-arrow-right p-1"></i></button>
          </a>
  		
    </div>
  </div>
</nav>

<h4 class="text-center text-success pt-5 ">Welcome back, <b><sec:authentication property="principal.username" />!</b> You're Logged in as \INSTRUCTOR!. <br> Here's Your Profile Information at a Glance </h4>
    <table class="table table-striped  mx-auto mt-4 shadow-sm  mb-5 bg-body-tertiary rounded" style="width: 600px">
	<thead>
		<tr>
		<th> Id</th>
		<th> Name</th>
		<th> City</th>
		<th> Age</th>
		
		
		
		</tr>
	</thead>
	<tbody>
		
			<tr>
			<td><c:out value="${instructor.id }"></c:out></td>
			
			<td><c:out value="${instructor.name }"></c:out></td>
			
			<td><c:out value="${instructor.city }"></c:out></td>
			<td><c:out value="${instructor.age }"></c:out></td>
			
			
			</tr>
		
	</tbody>
</table>

<h1 class="pt-5 pb-3 text-center text-success"> Courses You're Teaching </h1>
<table class="table table-striped p-5 mx-auto  shadow-sm   bg-body-tertiary rounded" style="width: 700px">
	<thead>
		<tr>
		<th> Id</th>
		<th> Name</th>
		<th>Description</th>
		
		
		</tr>
	</thead>
	<tbody>
		<c:forEach var="course" items="${courseList}">
			<tr>
			<td><c:out value="${course.id }"></c:out></td>
			
			<td><c:out value="${course.name}"></c:out></td>
			<td><c:out value="${course.description }"></c:out></td>
			
			
			
			
			
			
			
			</tr>
			
		</c:forEach>
	</tbody>
</table>

<h1 class="pt-5 pb-3 text-center text-success">Students in the Institute </h1>
<table class="table table-striped p-5 mx-auto  shadow-sm   bg-body-tertiary rounded" style="width: 700px">
	<thead>
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th> City</th>
		<th> age</th>
		<th>Actions</th>
		
		
		
		
		</tr>
	</thead>
	<tbody>
		<c:forEach var="student" items="${studentList}">
			<tr>
			<td><c:out value="${student.id }"></c:out></td>
			
			<td><c:out value="${student.name}"></c:out></td>
			<td><c:out value="${student.city }"></c:out></td>
			<td><c:out value="${student.age }"></c:out></td>
			
			<td><a href="getUserById?userId=<c:out value='${student.id }'/>"> <button type="submit" class="btn btn-success">Update</button></a></td>
			
			
			
			
			
			
			
			</tr>
			
		</c:forEach>
	</tbody>
</table>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>