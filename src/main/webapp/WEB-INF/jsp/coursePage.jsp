<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Course Page</title>
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
   <!--  <a  class="navbar-brand" href="addInstructor.jsp"  >
           <button type="button" class="btn btn-primary">Add Instructor</button>
          </a>
     <a  class="navbar-brand" href="addCourse.jsp"  >
           <button type="button" class="btn btn-primary">Add Course</button>
          </a>
      <a  class="navbar-brand" href="addCourseToInstructor.jsp"  >
           <button type="button" class="btn btn-primary">Assign Course</button>
          </a> -->
     
    <div   style="margin-right:100px">
    <a  href="/studentHomePage"  >
           <button type="button" class="btn btn-danger">Home<i class="bi bi-house-door"></i></button>
          </a>
  		
    </div>
    </div>
</nav>
		<div class="container p-5 shadow p-3 mb-5 bg-white rounded" style="width: 1000px;">
			<h1 class="text-center text-success pb-5">${course.name } </h1>
			<h5><b>Course Id: </b>${course.id }</h5>
			<h5 class="pb-2"><b>Instructor Details:</b></h5>
			<div class="shadow-none p-3 mb-5 bg-light rounded">
			<h6 style="margin-left: 50px;"><b>Name: </b>${instructor.name}</h6>
			<h6 style="margin-left: 50px;"><b>Id: </b>${instructor.getId()}</h6>
			<h6 style="margin-left: 50px;"><b>City: </b>${instructor.city}</h6>
			<h6 style="margin-left: 50px;"><b>Age: </b>${instructor.age}</h6>
			</div>
			
			<h6><b>Course Description: </b>${course.description}</h6>
			<h6><b>Course Duration: </b>6 Months</h6>
			<h6><b>Course Learning out comes:</b></h6>
			<div style="margin-left: 50px;">
				<p>1. Develop a solid understanding of fundamental concepts: Gain a strong foundation in the key principles and concepts related to the subject matter of the course.</p>
				<p>2. Acquire practical skills: Learn practical skills and techniques that can be applied in real-world scenarios or industry settings.</p>
				<p>3. Problem-solving and critical thinking: Enhance problem-solving abilities and develop critical thinking skills to analyze and solve technical challenges effectively.</p>
				<p>4. Hands-on experience: Gain hands-on experience through practical exercises, projects, or labs that allow for the application of theoretical knowledge.</p>
				<p>5. Proficiency in using relevant tools and technologies: Become proficient in using the tools, software, or technologies commonly employed in the field or specific domain covered by the course.</p>
				
			</div>
			<h6><b>Course Format: </b>Self paced</h6>
			
			
			
			
			
		</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>