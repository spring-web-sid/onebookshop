<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<template:cssTemplate/>
<title>Registration Page</title>
</head>
<body>
<template:jsTemplate/>

<!-- Navigation -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
	<div class="container-fluid">
		<a class="navbar-brand img-responsive" href="/"><img src="${contextPath}/resources/images/logobookstore.png" style="height:2em"/></a>
		<button class="navbar-toggler mr-auto" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav mb-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Books</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Category</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Contact Us</a>
					</li>
				</ul>
			</div>
	</div>
</nav>

<!-- Registration form -->
<div class="registrationForm container" style="margin-left:20em;">
<form action="${contextPath}/register/registerUser" modelAttribute="registrationForm" method="post">

<div class="row">

  <div class="form-group col-md-12">
    <label for="InputName">Name</label>
    <input type="text" class="form-control" name="name" placeholder="Full Name">
  </div>
  <div class="form-group col-md-12">
    <label for="InputPassword">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
  </div>
  <div class="form-group col-md-12">
    <label for="EmailAddress">Email Address</label>
    <input type="email" class="form-control" name="mailId" placeholder="Email Address">
     <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  
  <div class="form-group col-md-12">
    <label for="InputPassword">Address 1</label>
    <input type="text" class="form-control" name="address1" placeholder="flat no, street, village">
  </div>
  <div class="form-group col-md-12">
    <label for="InputPassword">Address 2</label>
    <input type="text" class="form-control" name="address2" placeholder="state, zip code">
  </div>
  <div class="form-group col-md-12">
    <label for="InputPassword">Phone No</label>
    <input type="number" class="form-control" name="phoneNo" placeholder="Phone No">
  </div>
  <input type="hidden" class="form-control" name="role" value="${role}" />
  <button type="submit" class="col-md-6 btn btn-primary ml-2" style="width:98%">Submit</button>

</div>
</form>



</div>

<!-- connect -->
	<div class="container-fluid padding">
		<div class="row text-center padding">
			<div class="col-12">
				<h3>Connect</h3>
			</div>
			<div class="col-12 social padding">
				<a href="#"><i class="fab fa-facebook"></i></a>
				<a href="#"><i class="fab fa-twitter"></i></a>
				<a href="#"><i class="fab fa-google-plus-g"></i></a>
				<a href="#"><i class="fab fa-instagram"></i></a>
				<a href="#"><i class="fab fa-youtube"></i></a>
			</div>
		</div>		
	</div>


</body>
</html>