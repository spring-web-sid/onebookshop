<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<template:cssTemplate />
	<title>Home Page</title>
</head>
<body>
<template:jsTemplate />

<!-- Navigation -->
<template:hearder />

<h1>This is login page for Users</h1>

<div id="login-box">

	<h3>Login with Username and Password</h3>

	<c:if test="${not empty error}">
		<div class="login-error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="login-msg">${msg}</div>
	</c:if>

	<form name='loginForm'
		  action="<c:url value='/user/j_spring_security_check' />"
		  method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>

			<tr>
				<td colspan='2'><input name="submit" type="submit"
									   value="submit" /></td>
			</tr>

		</table>

		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />

	</form>

</div>

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