<%--
  Created by IntelliJ IDEA.
  User: SiddharthaKLet
  Date: 3/25/2019
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <template:cssTemplate />
    <title>Home Page</title>
</head>
<body>
<template:jsTemplate />

<!-- Navigation -->
<template:hearder />
<!-- Book details here -->
<sec:authorize access="ROLE_BUYER">

</sec:authorize>
<sec:authorize access="ROLE_SELLER">

</sec:authorize>

<!-- connect -->
<div class="container-fluid padding">
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