<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-3 col-sm-3 col-md-3 col-xl-2 bd-sidebar">

    <div class="mt-5 innerFilter" >

            <c:forEach var="category" items="${categoryMap}" varStatus="root">
            <div class="filterItem">
                <a class="bd-toc-link rootCategory" href="#">
                    ${category.key}
                </a>

                <c:if test="${category.value.size() > 0}">
                <ul class="nav bd-sidenav subCategory">
                    <div class="accordion" id="accordion${root.count}">
                    <c:forEach var="subCat" items="${category.value}" varStatus="status">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${root.count}${status.count}">
                                    ${subCat.key}
                            </a>
                        </div>
                        <div id="collapse${root.count}${status.count}" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <c:forEach var="subSubCat" items="${subCat.value}">
                                    <ul style="list-style: none;" class="ml-auto">
                                        <li class="bd-toc-item">
                                            <a class="bd-toc-link" href="#">
                                                    ${subSubCat}
                                            </a>
                                        </li>
                                    </ul>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    </div>
                </ul>
                </c:if>
            </div>
            </c:forEach>
    </div>

</div>