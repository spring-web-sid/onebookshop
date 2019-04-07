<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<template:cssTemplate />
<title>Home Page</title>
</head>
<body>
<template:jsTemplate />
<!-- Navigation -->
<template:hearder />
<!-- image slider -->
	<!-- book details -->

<div class="container-fluid">
	<div class="row flex-xl-nowrap">
		<!-- Filter template -->
		<template:filter />
		<div class="mainContainer bookContainer mt-5 col-sm-9 col-md-9 col-lg-9 col-lg-9 py-md-3 bd-content" role="main">
			<div class="row justify-content-center">
		<c:forEach items="${bookList}" var="book">
            <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
			<div class="col-md-3 mx-2 my-2 col-sm-4 col-4 book">
				<div class="card">
					<a href="${contextPath}/guest/book/${book.bookUrl}"><img src="${contextPath}/${book.image}" class="card-img-top"
												   alt="Image will be available soon"></a></div>
				<div class="card-body">
					<h5 class="card-title">${book.name}</h5>
					<div style="width: 110%;float: none; margin-left: -8px;">
						<a class="btn btn-primary btn-responsive1" href="#">Add to Cart</a>
						<a class="btn btn-primary btn-responsive2" href="#">Buy Now</a>
					</div>
				</div>
			</div>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <div class="col-md-3 mx-2 my-2 col-sm-4 book">
                    <div class="card">
                        <a href="${contextPath}/user/book/${book.bookUrl}"><img src="${contextPath}/${book.image}" class="card-img-top"
                                                                                alt="Image will be available soon"></a></div>
                    <div class="card-body">
						<h5 class="card-title">${book.name}</h5>
						<div style="width: 110%;float: none; margin-left: -8px;">
						<a class="btn btn-primary btn-responsive1" href="#">Add to Cart</a>
						<a class="btn btn-primary btn-responsive2" href="#">Buy Now</a>
						</div>
                    </div>
                </div>
            </sec:authorize>
		</c:forEach>
			</div>
        </div>
    </div>

</div>

	<!-- connect -->
	<div class="container-fluid padding mt-5">
		<div class="row text-center padding">
			<div class="col-12">
				<h3>Connect</h3>
			</div>
			<div class="col-12 social padding">
				<a href="#"><i class="fab fa-facebook"></i></a> <a href="#"><i
					class="fab fa-twitter"></i></a> <a href="#"><i
					class="fab fa-google-plus-g"></i></a> <a href="#"><i
					class="fab fa-instagram"></i></a> <a href="#"><i
					class="fab fa-youtube"></i></a>
			</div>
		</div>
	</div>


</body>
</html>