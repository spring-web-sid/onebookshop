<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <template:cssTemplate />
<title>Insert title here</title>
</head>
<body>
<template:jsTemplate />
<template:hearder />

<input type="hidden" id="bookId" value="${bookData.bookId}"/>
Book Name : ${bookData.name}
Book Author : ${bookData.author}
<img src="${contextPath}/${bookData.image}" />

<input type="button" value="Add To Cart" onclick="return fnAddtoCart()" />
<input type="button" value="Buy Now" onclick="fnBuyNow" />

</body>
</html>