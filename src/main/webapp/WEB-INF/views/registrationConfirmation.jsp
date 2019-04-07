<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<template:cssTemplate/>
<title>Home Page</title>
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
			<div>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="${contextPath}/register/userRegistration">Sign Up</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
				</ul>
			</div>
	</div>
</nav>

<c:choose>
<c:when test="${bookNumber == '' || bookNumber == null}">
	<h1>Welcome ${userName} to our bookstore... Help us to serve you better... </h1>
	<h1>You have successfully registered. Please use the unique code for login..</h1>
	<h2>Unique code is : ${userId}</h2>
</c:when>
<c:otherwise>
	<h1>Book saved into our database</h1>
	<h2> Book Id : ${bookNumber}</h2>
</c:otherwise>
</c:choose>
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