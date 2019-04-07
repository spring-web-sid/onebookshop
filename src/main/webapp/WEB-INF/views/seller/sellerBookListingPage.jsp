<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <template:cssTemplate/>
    <title>Home Page</title>
</head>
<body>
<template:jsTemplate/>

<!-- Navigation -->
<template:hearder />
<!-- book details -->
<div class="row">

    <c:forEach items="${bookList}" var="book">
        <div class="col-md-2">
            <div class="card">
                <a href="${book.bookUrl}"><img src="${contextPath}/${book.image}" class="card-img-top"
                                               alt="Image will be available soon"></a></div>
            <div class="card-body">
                <p class="card-text">${book.description}</p>
            </div>
        </div>
    </c:forEach>

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