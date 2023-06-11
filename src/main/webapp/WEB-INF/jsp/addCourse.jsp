<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
    
  </head>
  <body>
  <nav class="navbar "style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="adminHomePage.jsp">
      <img src="https://www.taashee.com/wp-content/uploads/2023/02/taashee-logo-1000-x-2001.png" alt="Logo" width="280" height="60" class="d-inline-block align-text-top" style="margin-top: -20px">
      <span class="fs-1 fw-bold">T</span><span class="fs-3 " style="color:#61CE70">raining</span><span class="fs-1 fw-bold">A</span><span  class="fs-3" style="color:rgb(113,206,126)">cademy</span>
    
    </a>
    <div   style="margin-right:100px">
    <sec:authorize access="hasRole('ADMIN')">
    <a  href="/adminHomePage"  >
           <button type="button" class="btn btn-danger">Home<i class="bi bi-house-door"></i></button>
          </a>
  		</sec:authorize>
    </div>
  </div>
</nav>
	<c:if test="${Course== null }">
	<h2 class="text-center text-success pt-4">Enter Course Details</h2>
    <form action="addCourse" method="post" class="mx-auto p-5 mx-auto mt-5 shadow-sm p-3 mb-5 bg-body-tertiary rounded" style="width: 600px">
    </c:if>
    <c:if test="${Course!= null }">
	<h2 class="text-center text-success pt-4">Edit Course Details</h2>
    <form action="updateCourse" method="post" class="mx-auto p-5 mx-auto mt-5 shadow-sm p-3 mb-5 bg-body-tertiary rounded" style="width: 600px">
    <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Course Id</label>
    <input type="text" name="id" class="form-control" id="exampleInputPassword1" required value='<c:out value="${Course.id }"></c:out>'>
  </div>
    </c:if>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Course Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputPassword1" required value='<c:out value="${Course.name }"></c:out>'>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Course Description</label>
    <input type="text" name="description" class="form-control" id="exampleInputPassword1" required value='<c:out value="${Course.description }"></c:out>'>
  </div>
  <c:if test="${Course==null }">
  <button type="submit" class="btn btn-primary">Add Course</button>
  </c:if>
  <c:if test="${Course!=null }">
  <button type="submit" class="btn btn-primary">Update Course</button>
  </c:if>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>