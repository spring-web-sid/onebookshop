<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<header class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand img-responsive" href="/"><img
        src="${contextPath}/resources/images/logobookstore.png"
        style="height: 1.5em;" /></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link" href="#">Contact us</a>
            </li>
        </ul>
        <%--<div>
        <form class="form-inline my-2 my-lg-0">
            <input style="width:100%" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"><button type="submit"><i class="fas fa-search"></i></button></input>
        </form>
        </div>--%>

        <div class="input-group mr-4" style="width: 40%;">
            <input type="text" class="form-control" placeholder="Search book here">
            <div class="input-group-append">
                <button class="btn btn-secondary" type="button">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </div>

        <div id="userInfo">
        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <li class="nav-item" style="font-size:1.5em"><a class="nav-link" href="#"><i
                    class="fas fa-shopping-cart"></i><span class='cart cart-warning' id='lblCartCount'>${cart.entries.size()}</span></a>
            </li>
            <li class="nav-item" style="font-size:1.5em"><a class="nav-link" href="#"><i
                    class="fas fa-user-circle"></i></a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value='/seller/j_spring_security_logout' />">LogOut</a></li>
        </ul>
        </div>
    </div>
</header>