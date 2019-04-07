<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
        <a class="navbar-brand img-responsive" href="/"><img src="${contextPath}/resources/images/logobookstore.png"
                                                             style="height:2em"/></a>
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
<div class="container registrationForm">
    <form:form action="${contextPath}/seller/book/upload" modelAttribute="bookForm" method="post"
               enctype="multipart/form-data">

        <div class="row ml-div">

            <div class="form-group col-md-6">
                <label for="name">Name</label>
                <form:input type="text" class="form-control" path="name" placeholder="Name of book"/>
                <p><form:errors path="name" cssClass="error"/></p>
            </div>


            <div class="form-group col-md-6">
                <label for="author">Author</label>
                <form:input type="text" class="form-control" path="author" placeholder="Author of book"/>
                <p><form:errors path="author" cssClass="error"/></p>
            </div>


            <div class="form-group col-md-6">
                <label for="description">Description</label>
                <form:input type="text" class="form-control" path="description" placeholder="Some description about book" />
                <p><form:errors path="description" cssClass="error"/></p>
            </div>


            <div class="form-group col-md-6">
                <label for="basePrice">Base Price</label>
                <form:input type="text" class="form-control" path="basePrice" placeholder="Price of Book" />
                <p><form:errors path="basePrice" cssClass="error"/></p>
            </div>

            <div class="form-group col-md-6">
                <label for="tax">Tax</label>
                <form:input type="text" class="form-control" path="tax" placeholder="Tax if applicable" />
                <p><form:errors path="tax" cssClass="error"/></p>
            </div>

            <div class="form-group col-md-6">
                <label for="discount">Discount</label>
                <form:input type="text" class="form-control" path="discount" placeholder="Discount if applicable" />
                <p><form:errors path="discount" cssClass="error"/></p>
            </div>

            <div class="form-group col-md-6">
                <label for="specialDiscount">Special Discount</label>
                <form:input type="text" class="form-control" path="specialDiscount" placeholder="Special Discount if applicable" />
                <p><form:errors path="specialDiscount" cssClass="error"/></p>
            </div>

            <div class="form-group col-md-6">
                <label for="rootCategory">Select Category</label>
                <select class="form-control form-control-sm" name="rootCategory" id="rootCategory">
                    <option disabled selected>--Select Category--</option>
                    <c:forEach items="${rootCategoryList}" var="item">
                        <option value="${item}">${item}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group col-md-6">
                <label for="subCategory">Select Department</label>
                <form:select class="form-control form-control-sm" id="subCategory" path="subCategory"></form:select>
            </div>

            <div class="form-group col-md-6">
                <label for="subSubCategory">Select Class</label>
                <form:select class="form-control form-control-sm" id="subSubCategory" path="subSubcategory"></form:select>
            </div>

            <div class="form-group col-md-6">
                <label for="uploadImage">Upload Image</label>
                <input type="file" class="form-control-image" id="uploadImage" name="file"/>
                <p class="error">${fileUploadErr}</p>
            </div>

            <div class="form-group col-md-8 col-sm-8 com-lg-8" style="text-align: end"><button type="submit" class="col-md-8 btn btn-primary">Submit</button></div>

        </div>
    </form:form>


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